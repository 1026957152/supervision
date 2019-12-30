package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.config.Constants;
import org.ylgjj.loan.domain_flow.AnalysisStream;
import org.ylgjj.loan.domain_flow.AnalysisTable;
import org.ylgjj.loan.domain_flow.Config;
import org.ylgjj.loan.index.Index_1_SEQ_暂存款笔数_AND_0301000101;
import org.ylgjj.loan.index.Index_2_SEQ_实缴单位数_AND_0301000201;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.repository_flow.AnalysisStreamRepository;
import org.ylgjj.loan.repository_flow.AnalysisTableRepository;
import org.ylgjj.loan.repository_flow.ConfigRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("AnalysisServiceImpl")
public class AnalysisServiceImpl {

    @Autowired
    private AnalysisStreamRepository analysisStreamRepository;

    @Autowired
    private AnalysisTableRepository analysisTableRepository;

    @Autowired
    private ConfigRepository configRepository;


    @Autowired
    private Index_1_SEQ_暂存款笔数_AND_0301000101 index_1_seq_暂存款笔数_and_0301000101;
    @Autowired
    private Index_2_SEQ_实缴单位数_AND_0301000201 index_2_seq_实缴单位数_and_0301000201;

   // @PostConstruct
    @Transactional
    public void S_83_SEQ_住房公积金使用率_AND_0301020501__() {
        List<StatisticalIndexCodeEnum> statisticalIndexCodeEnums = Arrays.stream(StatisticalIndexCodeEnum.values()).collect(Collectors.toList());


        IntStream.range(0,statisticalIndexCodeEnums.size()).forEach(e->{

            StatisticalIndexCodeEnum statisticalIndexCodeEnum=    statisticalIndexCodeEnums.get(e);
            AnalysisTable analysisTable = analysisTableRepository.findByTargetNo(statisticalIndexCodeEnum.get指标编码());


            if(analysisTable== null){
                analysisTable = new AnalysisTable();
                analysisTable.setTargetNo(statisticalIndexCodeEnum.get指标编码());
                analysisTable.setSeq(e);

                analysisTableRepository.save(analysisTable);
            }


        });


    }


    //
    @Transactional
    public void config() {

            List<Config> configs = configRepository.findAll();//(statisticalIndexCodeEnum.get指标编码());


            if(configs.size()== 0){

                Config config_1 = new Config();



                Config config_2 = new Config();


                Config config_3 = new Config();
                config_3.setName("zjbzxbm");;
                config_3.setDesc("住建部中心编码");;
                config_3.setValue(Constants.zjbzxbm_住建部中心编码);;

                configRepository.saveAll(Arrays.asList(config_1,config_2,config_3));
            }



    }
    @Transactional
    public AnalysisStream beginSteam(AnalysisTable table, LocalDate beginDate, LocalDate endDate, String s, LocalDateTime analysisTable) {


        AnalysisStream analysisStream = new AnalysisStream();
        analysisStream.setBeginDateTime(analysisTable);
        analysisStream.setBeginDate(beginDate);
        analysisStream.setEndDate(endDate);
        analysisStream.setIndexNo(table.getTargetNo());
        analysisStream.setStatus("正在处理");
        analysisStream.setNo(s);
        analysisStreamRepository.save(analysisStream);

        return analysisStream;
    }
    @Transactional
    public void endSteam(AnalysisStream analysisStream, LocalDateTime analysisTable) {



        analysisStream.setEndDateTime(analysisTable);
        analysisStream.setStatus("处理结束");
        analysisStreamRepository.save(analysisStream);

    }
    @Transactional
    public void update(AnalysisTable analysisTable) {
        analysisTableRepository.save(analysisTable);




    }

    public void updateImmediately(StatisticalIndexCodeEnum fromString指标编码) {

        if(fromString指标编码 == StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101){
            index_1_seq_暂存款笔数_and_0301000101.update();
        }
    }

    public boolean historyImmediately(StatisticalIndexCodeEnum fromString指标编码) {
        if(fromString指标编码 == StatisticalIndexCodeEnum.S_1_SEQ_暂存款笔数_AND_0301000101){

            if(index_1_seq_暂存款笔数_and_0301000101.getLock().isLocked()){
                return false;
            }else{
                index_1_seq_暂存款笔数_and_0301000101.history();
                return true;
            }

        }

        if(fromString指标编码 == StatisticalIndexCodeEnum.S_2_SEQ_实缴单位数_AND_0301000201){

            if(index_2_seq_实缴单位数_and_0301000201.getLock().isLocked()){
                return false;
            }else{
                index_2_seq_实缴单位数_and_0301000201.history();
                return true;
            }

        }


        return false;
    }
}
