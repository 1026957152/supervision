package org.ylgjj.loan.index;


import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP021_单位缴存登记簿_缴存类型;
import org.ylgjj.loan.enumT.E_CM001_单位基本资料表_单位性质;
import org.ylgjj.loan.domain_flow.AnalysisStream;
import org.ylgjj.loan.domain_flow.AnalysisTable;
import org.ylgjj.loan.domain_flow.StreamHistory;
import org.ylgjj.loan.history_flow.BaseServiceImpl;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.AnalysisTableRepository;
import org.ylgjj.loan.repository_flow.StreamHistoryRepository;
import org.ylgjj.loan.service.AnalysisServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static org.ylgjj.loan.history_flow.DP021_单位缴存登记簿_Flow_HistoryerviceImpl.run统计周期编码;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("Index_1_SEQ_暂存款笔数_AND_0301000101")
public class Index_1_SEQ_暂存款笔数_AND_0301000101 extends BaseServiceImpl {


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
        List<Triplet<Long,LocalDate,LocalDate>> triplets = run统计周期编码(beginDateTotal,endDateTotal,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);
        triplets.stream().forEach(t->{


            LocalDate beginDate = t.getValue1();
            LocalDate endDate = t.getValue2();
            System.out.println("周期 开始："+beginDate + "  结束："+ endDate);


            dp021_单位缴存登记簿s
                    .stream()
                    .filter(x->x.getInaccdate不可为空入账日期().isAfter(beginDate) && x.getInaccdate不可为空入账日期().isBefore(endDate))


                    .collect(Collectors.toList()).stream().map(e -> {
                //TODO        获得某一日的缴存列表;


                System.out.println("入账日期："+e.getInaccdate不可为空入账日期());

                DP005_单位分户账 dp005_单位分户账 = dp005_单位分户账Map.get(e.getUnitaccnum单位账号());
                CM001_单位基本资料表 cm001_单位基本资料表 = cm001_单位基本资料表Map.get(dp005_单位分户账.getUnitcustid_单位客户号());

                return Triplet.with(e,
                        cm001_单位基本资料表,
                        dp005_单位分户账);
            })

                    .collect(Collectors.groupingBy(e -> e.getValue1().getAgentinstcode_经办机构())).entrySet().forEach(eee -> {
                System.out.println("经办机构："+eee.getKey());
                // TODO 按照 经济类型
                eee.getValue().stream().collect(Collectors.groupingBy(e -> e.getValue1().getUnitkind_单位性质())).entrySet().forEach(o -> {


                    try {
                        StreamHistory streamHistory  = new StreamHistory(beginDate,endDate,StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101);
                        System.out.println("存储："+streamHistory.toString());

                        streamHistory.setDimension1(pb007_机构信息表Map().get(eee.getKey()).getInstName()); // 机构名称
                     //   streamHistory.setDimension2(pb011_银行信息表Map().get(o.getKey()).getBankname()); // 银行名称
                        streamHistory.setDimension2(E_CM001_单位基本资料表_单位性质.fromString(o.getKey()).getDisplayText()); // 银行名称
                        streamHistory.setSeqNum(t.getValue0());

                        streamHistory.setIntValue(o.getValue().stream()

                                .filter(x->x.getValue0().getEndym_截止年月().equals(beginDate.with(TemporalAdjusters.firstDayOfMonth())))
                                .filter(x->x.getValue0().getBegym_开始年月().equals(beginDate.with(TemporalAdjusters.lastDayOfMonth())))
                                .filter(x->x.getValue0().getDptype_缴存类型().equals(E_DP021_单位缴存登记簿_缴存类型.预缴.getText()))
                                .collect(Collectors.groupingBy(x->x.getValue2().getUnitaccnum单位账号())).size());  //
                        streamHistory = streamHistoryRepository.save(streamHistory);
                    }catch (Exception e){
                        e.printStackTrace();
                    }





                });


            });







        });







        lock.unlock();







    }



    public synchronized void history() {


        AnalysisTable analysisTable = analysisTableRepository.findByTargetNo(StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102.get指标编码());

        LocalDate beginDate = LocalDate.now().minusDays(100);
        LocalDate endDate = LocalDate.now();
        AnalysisStream analysisStream = analysisService.beginSteam(analysisTable,beginDate,endDate,UUID.randomUUID().toString(),LocalDateTime.now());
        try{
            index(beginDate,endDate);
            logger.info("update"+statisticalIndexCodeEnum);
            analysisTable.setUpdateTime(LocalDateTime.now());
            analysisService.update(analysisTable);
        }catch (Exception e){
        }
        analysisService.endSteam(analysisStream,LocalDateTime.now());
    }






    public void update() {

        AnalysisTable analysisTable = analysisTableRepository.findByTargetNo(StatisticalIndexCodeEnum.S_66_SEQ_暂存款余额_AND_0301008102.get指标编码());
        try{
            index(analysisTable.getModifyDate().toLocalDate(),LocalDate.now());
            logger.info("update"+statisticalIndexCodeEnum);
            analysisTable.setUpdateTime(LocalDateTime.now());
            analysisService.update(analysisTable);
        }catch (Exception e){

        }

    }


}
