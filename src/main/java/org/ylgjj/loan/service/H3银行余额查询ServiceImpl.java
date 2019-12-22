package org.ylgjj.loan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ylgjj.loan.domain.Data;
import org.ylgjj.loan.domain.Query;
import org.ylgjj.loan.domain.ReturnResult;
import org.ylgjj.loan.repository.AN004Repository;
import org.ylgjj.loan.repository.PB010_bank_info_大行信息表Repository;

import java.util.Date;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service
public class H3银行余额查询ServiceImpl {

    @Autowired
    private AN004Repository an004Repository;


    @Autowired
    private PB010_bank_info_大行信息表Repository pb010_bank_info_大行信息表Repository;



    public ReturnResult 逾期监管汇总查询(String zjbzxbm) {
        return null;
    }


    class ReturnDate{
        Data data;
        Date lastDate;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Date getLastDate() {
            return lastDate;
        }

        public void setLastDate(Date lastDate) {
            this.lastDate = lastDate;
        }
    }

}
