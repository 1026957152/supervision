package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.*;
import org.ylgjj.loan.enumT.E_DP029_定期存款分户文件_资金性质;
import org.ylgjj.loan.enumT.E_FD012_银行存款账号登记文件_FUNDKIND_资金性质;
import org.ylgjj.loan.history_stream.HistoryServiceImpl;
import org.ylgjj.loan.output.H8_1银行专户余额_银行专户余额查询;
import org.ylgjj.loan.pojo.QueryH8_1银行专户余额_银行专户余额查询;
import org.ylgjj.loan.repository.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("H8银行专户余额ServiceImpl")
public class H8银行专户余额ServiceImpl extends HistoryServiceImpl {

    @Autowired
    private FD012_银行存款账号登记文件Repository fd012_银行存款账号登记文件Repository;

    @Autowired
    private FN090_账户变动通知文件_Repository fn090_账户变动通知文件_repository;
    @Autowired
    private FD029_定期存款分户文件Repository fd029_定期存款分户文件Repository;

    @Autowired
    private PB011_银行信息表Repository pb011_银行信息表_repository;

    @Autowired
    private FD032_定期存款收息注销登记文件Repository fd032_定期存款收息注销登记文件Repository;




    public Output H8_1银行专户余额_银行专户余额查询(QueryH8_1银行专户余额_银行专户余额查询 query) {

/*        List<FD032_定期存款收息注销登记文件> fd032_定期存款收息注销登记文件s = fd032_定期存款收息注销登记文件Repository.findAll();
        List<PB011_银行信息表> pb011_银行信息表s = pb011_银行信息表_repository.findAll();*/


        DateTimeFormatter df_date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      //  LocalDate ldt_ksrq = LocalDate.parse(query.getKsrq(),df);
        LocalDate ldt_jsrq = LocalDate.parse(query.getJsrq(),df_date);


        List<FD029_定期存款分户文件>  fd029_定期存款分户文件s = fd029_定期存款分户文件Repository.findAll();
        List<FD012_银行存款账号登记文件> fd012_银行存款账号登记文件s = fd012_银行存款账号登记文件Repository.findAll();




        fd029_定期存款分户文件s.stream().map(e->{

            e.getOpnaccbank_不可为空_开户银行();
            e.getTrsoutbank_不可为空_转出银行();

            System.out.println("------------------------"+e.getOpnaccbank_不可为空_开户银行()+"---"+e.getTrsoutbank_不可为空_转出银行());

            return null;
        });



        Map<String, List<FD029_定期存款分户文件>> 定期账户Map = fd029_定期存款分户文件s.stream().collect(Collectors.groupingBy(e->e.getOpnaccbank_不可为空_开户银行()));


        定期账户Map.entrySet().forEach(f->{
            System.out.println("------定期账户Map----定期账户Map-----------"+ f.getKey());
        });

        /*

        int pageNumber = 1;
        int pageSize = 10;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder
                .createQuery(Long.class);
        countQuery.select(criteriaBuilder
                .count(countQuery.from(FN090_账户变动通知文件.class)));
        Long count = entityManager.createQuery(countQuery)
                .getSingleResult();

        CriteriaQuery<FN090_账户变动通知文件> criteriaQuery = criteriaBuilder
                .createQuery(FN090_账户变动通知文件.class);
        Root<FN090_账户变动通知文件> from = criteriaQuery.from(FN090_账户变动通知文件.class);
        CriteriaQuery<FN090_账户变动通知文件> select = criteriaQuery.select(from);

        TypedQuery<FN090_账户变动通知文件> typedQuery = entityManager.createQuery(select);
        while (pageNumber < count.intValue()) {
            typedQuery.setFirstResult(pageNumber - 1);
            typedQuery.setMaxResults(pageSize);
            System.out.println("Current page: " + typedQuery.getResultList());
            pageNumber += pageSize;
        }

        List<FN090_账户变动通知文件> fooList = typedQuery.getResultList();

*/


        /*
        Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期Desc("961009010000505583", PageRequest.of(0, 100));


        Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                findByBankaccnum不可为空账号OrderByTransdate不可为空写入日期Desc("961009010000505583", PageRequest.of(0, 100));

*/



     //   h8_1银行专户余额_银行专户余额查询.setGjzhye_活期归集账户余额_String(fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额());


        DecimalFormat df = new DecimalFormat("0.0000");


        List<H8_1银行专户余额_银行专户余额查询> aaaaa = fd012_银行存款账号登记文件s.stream().map(e->{
            H8_1银行专户余额_银行专户余额查询 h8_1银行专户余额_银行专户余额查询 = new H8_1银行专户余额_银行专户余额查询();
            h8_1银行专户余额_银行专户余额查询.setBm_银行编码(e.getBANKCODE_不可为空_银行代码());
            h8_1银行专户余额_银行专户余额查询.setMc_银行名称(e.getBANKACCNM_不可为空_银行账户名称());
            h8_1银行专户余额_银行专户余额查询.setSszh_总行编码_String(e.getBANKCODE_不可为空_银行代码());


            System.out.println("------定期账户Map----xuyao xuya odfsdf ds -----------"+ e.toString());
            List<FD029_定期存款分户文件> fd029_定期存款分户文件s1 = 定期账户Map.get(e.getBANKCODE_不可为空_银行代码());



            if(fd029_定期存款分户文件s1 != null){
                Map<String,List<FD029_定期存款分户文件>> ssssss= fd029_定期存款分户文件s1.stream().collect(Collectors.groupingBy(eeee->eeee.getFundkind_不可为空_资金性质()));
                if(ssssss.get(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_02_委托贷款户.getText()) != null){

    /*                double sss= ssssss.get(E_DP029_定期存款分户文件_资金性质.E_01_住房公积金存款).stream().mapToDouble(ff->ff.getDepoamt_不可为空_存单金额()).sum();
                    h8_1银行专户余额_银行专户余额查询.setDqdkzhye_定期贷款账户余额_String(sss+"");*/
                }
                if(ssssss.get(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_01_住房公积金存款.getText()) != null){
                    double sss= ssssss.get(E_DP029_定期存款分户文件_资金性质.E_01_住房公积金存款.getText()).stream().mapToDouble(ff->ff.getDepoamt_不可为空_存单金额()).sum();
                    h8_1银行专户余额_银行专户余额查询.setDqgjzhye_定期归集账户余额_String(BigDecimal.valueOf(sss).toPlainString());
                }

                if(ssssss.get(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_03_增值收益存款.getText()) != null){
                    double sss= ssssss.get(E_DP029_定期存款分户文件_资金性质.E_03_增值收益存款.getText()).stream().mapToDouble(ff->ff.getDepoamt_不可为空_存单金额()).sum();
                    h8_1银行专户余额_银行专户余额查询.setDqzzsyzhye_定期增值收益账户余额_String(BigDecimal.valueOf(sss).toPlainString());
                }
            }




            if(e.getFUNDKIND_不可为空_资金性质().equals(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_01_住房公积金存款.getText())){
                Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                        findByTransdate不可为空写入日期AndBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(ldt_jsrq.plusDays(1),e.getBANKACCNUM_不可为空_银行账号(), PageRequest.of(0, 10));
                if(!fn090_账户变动通知文件s.getContent().isEmpty()){
                    System.out.println("账户余额："+fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额());
                    h8_1银行专户余额_银行专户余额查询
                            .setGjzhye_活期归集账户余额_String(BigDecimal.valueOf(fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额()).toPlainString());

                }else{
                    h8_1银行专户余额_银行专户余额查询
                            .setGjzhye_活期归集账户余额_String("0");
                }
            }
            if(e.getFUNDKIND_不可为空_资金性质().equals(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_02_委托贷款户.getText())){
                Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                        findByTransdate不可为空写入日期AndBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(ldt_jsrq.plusDays(1),e.getBANKACCNUM_不可为空_银行账号(), PageRequest.of(0, 10));
                if(!fn090_账户变动通知文件s.getContent().isEmpty()){
                    System.out.println("账户余额："+fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额());
                    h8_1银行专户余额_银行专户余额查询
                            .setDkzhye_活期贷款账户余额_String(BigDecimal.valueOf(fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额()).toPlainString());

                }else{
                       h8_1银行专户余额_银行专户余额查询.setDkzhye_活期贷款账户余额_String("0");
                }
            }

            if(e.getFUNDKIND_不可为空_资金性质().equals(E_FD012_银行存款账号登记文件_FUNDKIND_资金性质.E_03_增值收益存款.getText())){
                Page<FN090_账户变动通知文件> fn090_账户变动通知文件s = fn090_账户变动通知文件_repository.
                        findByTransdate不可为空写入日期AndBankaccnum不可为空账号OrderByTransdate不可为空写入日期DescBankhostsernum不可为空银行主机流水号Desc(ldt_jsrq.plusDays(1),e.getBANKACCNUM_不可为空_银行账号(), PageRequest.of(0, 10));
                if(!fn090_账户变动通知文件s.getContent().isEmpty()){
                    System.out.println("账户余额："+fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额());
                    h8_1银行专户余额_银行专户余额查询
                            .setZzsyzhye_活期增值收益账户余额_String(BigDecimal.valueOf(fn090_账户变动通知文件s.getContent().get(0).getCurrbal__不可为空__余额()).toPlainString());

                }else{
                    h8_1银行专户余额_银行专户余额查询.setZzsyzhye_活期增值收益账户余额_String("0");
                }
            }


            //String num = df.format(d);
            //System.out.println(num);
          //  h8_1银行专户余额_银行专户余额查询.setDkzhye_活期贷款账户余额_String(df.format(h8_1银行专户余额_银行专户余额查询.getDkzhye_活期贷款账户余额_String()));
         //   h8_1银行专户余额_银行专户余额查询.setZzsyzhye_活期增值收益账户余额_String(df.format(h8_1银行专户余额_银行专户余额查询.getZzsyzhye_活期增值收益账户余额_String()));
           // h8_1银行专户余额_银行专户余额查询.setGjzhye_活期归集账户余额_String(df.format(h8_1银行专户余额_银行专户余额查询.getGjzhye_活期归集账户余额_String()));
          //  h8_1银行专户余额_银行专户余额查询.setDkzhye_活期贷款账户余额_String(df.format(h8_1银行专户余额_银行专户余额查询.getDkzhye_活期贷款账户余额_String()));

            return h8_1银行专户余额_银行专户余额查询;

        }).collect(Collectors.toList());


/*        aaaaa.stream().collect(Collectors.groupingBy(e->{
            return pb011_银行信息表Map().get(e.getBm_银行编码()).getSUPERBANKCODE();

        })).entrySet().stream()
        .map(e->{
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getDqdkzhye_定期贷款账户余额_String()).doubleValue()).sum();
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getDqgjzhye_定期归集账户余额_String()).doubleValue()).sum();
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getDqzzsyzhye_定期增值收益账户余额_String()).doubleValue()).sum();
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getDkzhye_活期贷款账户余额_String()).doubleValue()).sum();
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getZzsyzhye_活期增值收益账户余额_String()).doubleValue()).sum();
            e.getValue().stream().mapToDouble(x-> new BigDecimal(x.getGjzhye_活期归集账户余额_String()).doubleValue()).sum();

        });*/

        Output output = new Output();
        output.setData(aaaaa);
        return output;
    }
}
