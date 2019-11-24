package org.ylgjj.loan.util;

/**
 * Created by Administrator on 2015/10/7.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class 个人Utils {
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;

    public static Calendar calendar = Calendar.getInstance();



    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromToday_short(Date date) {

        return null;

    }



    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start  =null;
        try {
            start = format.parse("2016-05-04 00:11");// 开始日期
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        ;
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyyMMdd")
              //  .parseDefaulting(ChronoField.DAY_OF_MONTH, 0)

                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
       // System.out.println(LocalDate.from(DateTimeFormatter.ofPattern("yyyyMM").parse("201906")));
        System.out.println(LocalDateTime.from(formatter.parse("20190601")));

    }


    public static boolean 非本市缴存职工(String s) {
        int nativePlaceCode=Integer.parseInt(s.substring(0, 6));
        System.out.println(nativePlaceCode);
        String nativePlace=NativePlace.getNativePlace(nativePlaceCode);
        System.out.println(nativePlace);

        return true;
    }
}