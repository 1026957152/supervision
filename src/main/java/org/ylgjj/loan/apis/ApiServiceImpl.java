package org.ylgjj.loan.apis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.api.SupervisionController;
import org.ylgjj.loan.domain_flow.ApiCacheAnalysisItem;
import org.ylgjj.loan.domain_flow.ApiCacheAnalysisTable;
import org.ylgjj.loan.rates.SY_137_ljffbs_累计发放笔数_RateServiceImpl;
import org.ylgjj.loan.repository_flow.ApiCacheAnalysisTableRepository;
import org.ylgjj.loan.repository.LN003_合同信息_Repository;
import org.ylgjj.loan.repository_flow.ApiCacheAnalysisItemRepository;
import org.ylgjj.loan.repository_flow.RateAnalysisStreamRepository;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class ApiServiceImpl {


    @Autowired
    private LN003_合同信息_Repository ln003_合同信息_repository;
    @Autowired
    private RateAnalysisStreamRepository rateAnalysisStreamRepository;
    @Autowired
    private ApiCacheAnalysisItemRepository apiCacheAnalysisItemRepository;
    @Autowired
    private ApiCacheAnalysisTableRepository apiCacheAnalysisTableRepository;
    @Autowired
    private SY_137_ljffbs_累计发放笔数_RateServiceImpl sy_137_ljffbs_累计发放笔数_rateService;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");




 //

    @Transactional
    public void S_83_SEQ_住房公积金使用率_AND_0301020501__() {


       SupervisionController.api.stream().forEach(e->{


           ApiCacheAnalysisTable analysisTable = apiCacheAnalysisTableRepository.findByIndexNo(e.get服务编号());


            if(analysisTable== null){
                analysisTable = new ApiCacheAnalysisTable();
                analysisTable.setIndexNo(e.get服务编号());
                analysisTable.setName(e.get服务名称());
                analysisTable.setPath(e.get服务地址());

             //   analysisTable.setSeq(e);

                apiCacheAnalysisTableRepository.save(analysisTable);
            }


        });


    }


    @Transactional
    public void updateLastId(ApiCacheAnalysisTable apiCacheAnalysisTable, String datemodified) {
        apiCacheAnalysisTable.setLastId(datemodified);
        apiCacheAnalysisTableRepository.save(apiCacheAnalysisTable);
    }

    public void cacheItem(ApiCacheAnalysisTable apiCacheAnalysisTable, String name, String toString) {

    }

    public void cacheItems(List<ApiCacheAnalysisItem> collect) {
        apiCacheAnalysisItemRepository.saveAll(collect);

    }

    public List<ApiCacheAnalysisItem> get(ApiCacheAnalysisTable apiCacheAnalysisTable) {
        return apiCacheAnalysisItemRepository.findByTableId(apiCacheAnalysisTable.getId());
    }

    public ApiCacheAnalysisTable getApiCacheAnalysisTable(String s) {
        return      apiCacheAnalysisTableRepository.findByIndexNo("090601");

    }




/*
    @Scheduled(fixedRate = 1000*60*118)
    public void process() {

        sy_137_ljffbs_累计发放笔数_rateService.update();


    }
*/




}
