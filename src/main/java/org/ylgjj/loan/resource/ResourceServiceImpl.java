package org.ylgjj.loan.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ylgjj.loan.domain.CM001_单位基本资料表;
import org.ylgjj.loan.domain.DP021_单位缴存登记簿;
import org.ylgjj.loan.domain.Output;
import org.ylgjj.loan.enumT.E_HX_机构_Institution_info_instCodeEnum;
import org.ylgjj.loan.outputenum.E_住建部编码_收入水平;
import org.ylgjj.loan.outputenum.E_银行编码_HX;
import org.ylgjj.loan.outputenum.StatisticalIndexCodeEnum;
import org.ylgjj.loan.outputenum.统计周期编码;
import org.ylgjj.loan.repository.*;
import org.ylgjj.loan.repository_flow.UnitManagementAccountRepository;
import org.ylgjj.loan.util.DateUtilsss;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("ResourceServiceImpl")
public class ResourceServiceImpl {


    @Autowired
    ResourceLoader resourceLoader;


    @PostConstruct

    public void S_83_SEQ_住房公积金使用率_AND_0301020501__() {
        Arrays.stream(E_银行编码_HX.values()).forEach(e->{
            Resource resource = resourceLoader.getResource("classpath:各银行图标png/"+e.getLogoPath());

            try {
                InputStream input = resource.getInputStream();
                byte[] bytes = IOUtils.toByteArray(input);

                String encoded = Base64.getEncoder().encodeToString(bytes);

                System.out.println(encoded+"---------------");
                File file = resource.getFile();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        });



    }


}
