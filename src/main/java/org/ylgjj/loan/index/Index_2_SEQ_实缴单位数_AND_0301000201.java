package org.ylgjj.loan.index;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP005_单位分户账;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.enumT.E_CM001_单位基本资料表_单位性质;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.flow.AnalysisStream;
import org.ylgjj.loan.flow.AnalysisTable;
import org.ylgjj.loan.flow.LoanHistory;
import org.ylgjj.loan.flow.StreamHistory;
import org.ylgjj.loan.history_flow.BaseServiceImpl;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.DP021_单位缴存登记薄Repository;
import org.ylgjj.loan.repository_flow.AnalysisTableRepository;
import org.ylgjj.loan.repository_flow.StreamHistoryRepository;
import org.ylgjj.loan.service.AnalysisServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("Index_2_SEQ_实缴单位数_AND_0301000201")
public class Index_2_SEQ_实缴单位数_AND_0301000201 extends BaseServiceImpl {


    public ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    private StatisticalIndexCodeEnum statisticalIndexCodeEnum = StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102;

    @Autowired
    private AnalysisTableRepository analysisTableRepository;

    @Autowired
    private StreamHistoryRepository streamHistoryRepository;

    @Autowired
    private DP021_单位缴存登记薄Repository dp021_单位缴存登记薄Repository;
    @Autowired
    private AnalysisServiceImpl analysisService;

    //
    public void test() {

        List<Triplet<Long,LocalDate,LocalDate>> t = run统计周期编码( LocalDate.now().minusDays(3),LocalDate.now(),StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102);

        System.out.println( t+"dddddddddddddddddd");
    }




    @Transactional
    public void index(LocalDate beginDateTotal, LocalDate endDateTotal) {
        lock.lock();
        List<DP021_单位缴存登记簿> dp021_单位缴存登记簿s = dp021_单位缴存登记薄Repository.findByRegdate不可为空登记日期Between(beginDateTotal.minusDays(1),endDateTotal.plusDays(1));
        System.out.println("beginDate----------"+ beginDateTotal+"----------endDate----"+endDateTotal);

        List<String> dp = new ArrayList(dp021_单位缴存登记簿s.stream().map(e->e.getUnitaccnum单位账号()).collect(Collectors.toSet()));
        dp021_单位缴存登记簿s.forEach(e->{
            System.out.println("登记日期 "+e.getRegdate不可为空登记日期());
        });



        Map<String, DP005_单位分户账> dp005_单位分户账Map = dp005_单位分户账Map(dp);
        Map<String, CM001_单位基本资料表> cm001_单位基本资料表Map = cm001_单位基本资料表Map(dp);
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();




            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                DP005_单位分户账 dp005__单位分户账 = dp005_单位分户账Map.get(e.getUnitaccnum单位账号());


                return Triplet.with(e,
                        cm001_单位基本资料表Map.get(dp005__单位分户账.getUnitcustid_单位客户号()),
                        dp005__单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {

                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    // S_2_SEQ_实缴单位数_AND_0301000201("0301","0301000201","实缴单位数"," ","01","03","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0","02",false),
                    //      S_3_SEQ_实缴单位数__按年___AND_0301000202("0301","0301000202","实缴单位数(按年)"," ","01","06","bm_khjg","机构","bm_dwjjlx","经济类型"," "," ","0"," ",false),

                    StreamHistory loanHistory  = new StreamHistory(beginDate,endDate,StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201);


                    loanHistory.setDimension1(eee.getKey()); // 机构名称
                    loanHistory.setDimension2(o.getKey()); // 银行名称
                    loanHistory.setSeqNum(t.getValue0());
                    loanHistory.setIntValue(o.getValue().stream()

                            .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                            .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                            .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.汇缴.getText()))
                            .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                    streamHistoryRepository.save(loanHistory);


                });


            });




        });






        lock.unlock();







    }



    public synchronized void history() {


        AnalysisTable analysisTable = analysisTableRepository.findByIndexNo(StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201.get指标编码());

        LocalDate beginDate = LocalDate.now().minusDays(100);
        LocalDate endDate = LocalDate.now();


        AnalysisStream analysisStream = analysisService.beginSteam(analysisTable,beginDate,endDate,UUID.randomUUID().toString(),LocalDateTime.now());
       // 开始

        try{
            index(beginDate,endDate);
            logger.info("update"+statisticalIndexCodeEnum);
            analysisTable.setUpdateTime(LocalDate.now());
            analysisService.update(analysisTable);
        }catch (Exception e){
        }

        analysisService.endSteam(analysisStream,LocalDateTime.now());
        // 结束
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
