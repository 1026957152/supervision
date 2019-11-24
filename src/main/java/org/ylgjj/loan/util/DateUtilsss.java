package org.ylgjj.loan.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
 
public class DateUtilsss {
 
    /**
     * 计算当前日期与{@code endDate}的间隔天数
     *
     * @param endDate
     * @return 间隔天数
     */
    public static long until(LocalDate endDate){
        return LocalDate.now().until(endDate, ChronoUnit.DAYS);
    }
 
    /**
     * 计算日期{@code startDate}与{@code endDate}的间隔天数
     *
     * @param startDate
     * @param endDate
     * @return 间隔天数
     */
    public static long until(LocalDate startDate, LocalDate endDate){
        return startDate.until(endDate, ChronoUnit.DAYS);
    }
 
        public static void main(String[] args) {
            LocalDate startDate =  LocalDate.of(2018, Month.DECEMBER,3);
            LocalDate endDate =  LocalDate.of(2018, Month.DECEMBER,29);
 
            System.out.println(until(endDate));
            System.out.println(until(startDate,endDate));
            System.out.println(until(startDate,endDate)/7+1);
        }
 
}
/*
————————————————
版权声明：本文为CSDN博主「骑着毛驴开大奔」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_19316267/article/details/84818237*/
