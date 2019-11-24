package org.ylgjj.loan.engine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.engine.agent.Individual;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.outputenum.*;
import org.ylgjj.loan.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("engineServiceImpl")
public class EngineServiceImpl {


    List<Individual> individuals = new ArrayList<>();
    // TODO
    public Output S_81_SEQ_住房公积金归集增长率_AND_0301020301(String dimension1, String dimension2, String dimension3, 统计周期编码 valueOf, StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {

        Individual individual =null;// new Individual();
        List<Individual> individuals = new ArrayList<>();
        return null;
    }






    // TODO
    public Output 获得总余额(String dimension1,  StatisticalIndexCodeEnum valueOf1, String ksrq, String jsrq) {
        individuals.stream().map(individuals->{
            return individuals.toString();
        });

        return null;
    }

    BigDecimal totalWithDrawAmt = BigDecimal.ZERO;
    // TODO
    public void RUN(String dimension1,   String ksrq, String jsrq) {

        for(int n = 10;n<200;n++){
            tick(dimension1);




          //  calculate(individuals);
        }
    }


    // TODO
    public Output tick(String dimension1) {
        individuals.stream().map(individuals->{
            return individuals.toString();
        });
        return null;
    }

    // TODO
    public Output calculate(List<Individual> individuals,Integer n) {
/*        if(n=1){

        }*/
        individuals.stream().map(individual->{
            return individuals.toString();
        });
        return null;
    }
    // TODO 由引擎产生 该项目指标的一个 以天为单位的 长序列， 供其他层调用啊啊啊。
}
