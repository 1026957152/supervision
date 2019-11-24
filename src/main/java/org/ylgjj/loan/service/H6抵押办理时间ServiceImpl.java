package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.LN009_抵押物信息mortgager_goods_info;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.output.H6_1抵押办理时间_抵押物数据查询;
import org.ylgjj.loan.output.H6_2抵押办理时间_抵押物明细数据查询;
import org.ylgjj.loan.repository.LN009_抵押物信息_mortgager_goods_info_Repository;
import org.ylgjj.loan.repository.LN010_mortgager_info_Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H6抵押办理时间ServiceImpl")
public class H6抵押办理时间ServiceImpl {

    @Autowired
    private LN009_抵押物信息_mortgager_goods_info_Repository ln009_抵押物信息_mortgager_goods_info_repository;




    public Output H6_1抵押办理时间_抵押物数据查询(String zjbzxbm) {
        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos = ln009_抵押物信息_mortgager_goods_info_repository.findTop100By();

        H6_1抵押办理时间_抵押物数据查询 h6_1抵押办理时间_抵押物数据查询 = new H6_1抵押办理时间_抵押物数据查询();

        h6_1抵押办理时间_抵押物数据查询.setDay1_7天以内_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay2_7__15天_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay3_15__30天_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setDay4_30天以上_varchar__20___输出("");
        h6_1抵押办理时间_抵押物数据查询.setZjbzxbm_住建部中心编码_varchar__60___输出("");


        Output output = new Output();
        output.setData(Arrays.asList(h6_1抵押办理时间_抵押物数据查询));
        return output;
    }

    public Output H6_2抵押办理时间_抵押物明细数据查询(String zjbzxbm) {

        List<LN009_抵押物信息mortgager_goods_info> ln009_抵押物信息mortgager_goods_infos = ln009_抵押物信息_mortgager_goods_info_repository.findTop100By();

        ln009_抵押物信息mortgager_goods_infos.stream().map(e->{
            H6_2抵押办理时间_抵押物明细数据查询 h6_2抵押办理时间_抵押物明细数据查询 = new H6_2抵押办理时间_抵押物明细数据查询();



            h6_2抵押办理时间_抵押物明细数据查询.setJkhtbh_借款人合同编号(e.getLoancontrcode_不可为空_合同代码());
            h6_2抵押办理时间_抵押物明细数据查询.setJkrgjjzh_借款人公积金账号("");
            h6_2抵押办理时间_抵押物明细数据查询.setJkrxm_借款人姓名("");

       //     h6_2抵押办理时间_抵押物明细数据查询.setDkffe_贷款金额("");


          //  h6_2抵押办理时间_抵押物明细数据查询.setDksqnx_贷款年限("");
          //  h6_2抵押办理时间_抵押物明细数据查询.setDkll_贷款利率("");

            h6_2抵押办理时间_抵押物明细数据查询.setSprq_审批日期(e.getCeroutdate_可为空_出证日期());
            h6_2抵押办理时间_抵押物明细数据查询.setDkffrq_发放日期("");
            return h6_2抵押办理时间_抵押物明细数据查询;
        }).collect(Collectors.toList());
        Output output = new Output();
        output.setData(ln009_抵押物信息mortgager_goods_infos);
        return output;
    }



}
