package org.ylgjj.loan.index;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP005_单位分户账;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.flow.AnalysisTable;
import org.ylgjj.loan.flow.Config;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.history_flow.BaseServiceImpl;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository_flow.AnalysisTableRepository;
import org.ylgjj.loan.repository_flow.LoanHistoryRepository;
import org.ylgjj.loan.service.AnalysisServiceImpl;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("Index_11_SEQ_缴暂存款净额_AND_0301001001")
public class Index_11_SEQ_缴暂存款净额_AND_0301001001 extends BaseServiceImpl {



    private StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102;

    @Autowired
    private AnalysisTableRepository analysisTableRepository;

    @Autowired
    private LoanHistoryRepository loanHistoryRepository;

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;
    @Autowired
    private AnalysisServiceImpl analysisService;

    //
    public void test() {

        List<Triplet<Long,LocalDate,LocalDate>> t = run统计周期编码( LocalDate.now().minusDays(3),LocalDate.now(),StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

        System.out.println( t+"dddddddddddddddddd");
    }




    public void index(LocalDate beginDateTotal, LocalDate endDateTotal) {

        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = dp021_单位缴存登记簿s.stream().map(e->e.getUnitaccnum单位账号()).collect(Collectors.toList());
        dp021_单位缴存登记簿s.forEach(e->{
            System.out.println("登记日期 "+e.getRegdate不可为空登记日期());
        });



        Map<String, DP005_单位分户账> dp005_单位分户账Map = dp005_单位分户账Map(dp);
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();

            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;

                DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账Map.get(e.getUnitaccnum单位账号());

                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());


                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    LoanHistory loanHistory  = new LoanHistory(beginDate,StatisticalIndexCodeEnum.S_11_SEQ_缴暂存款净额_AND_0301001001);


                    loanHistory.setIndex机构编码(eee.getKey()); // 机构名称
                    loanHistory.setIndex提取原因(o.getKey()); // 银行名称
                    loanHistory.setDoubleValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            //.filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                            .mapToDouble(x->{
                                if(x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText())){
                                    return x.getValue0().getUpaytotamt_应缴总额().doubleValue();
                                }else{
                                    return -x.getValue0().getUprepayamt_预缴户转出金额().doubleValue();
                                }

                            }).sum()
                    );  //
                    loanHistoryRepository.save(loanHistory);
                });


            });







        });













    }




    public void history() {


        Config config = configMap().get("aa");

        AnalysisTable analysisTable = analysisTableRepository.findByIndexNo(StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102.get指标编码());

        try{
            index(LocalDate.now().minusDays(10),LocalDate.now());
            logger.info("update"+statisticalIndexCodeEnum);
            analysisTable.setUpdateTime(LocalDate.now());
            analysisService.update(analysisTable);
        }catch (Exception e){


        }

    }






    public void update() {

        AnalysisTable analysisTable = analysisTableRepository.findByIndexNo(StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102.get指标编码());
        try{
            index(analysisTable.getModifyDate().toLocalDate(),LocalDate.now());
            logger.info("update"+statisticalIndexCodeEnum);
            analysisTable.setUpdateTime(LocalDate.now());
            analysisService.update(analysisTable);
        }catch (Exception e){

        }

    }


}
