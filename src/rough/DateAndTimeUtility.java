package rough;

/*
 *  Copyright (C) 2022 Canadian tire corporation, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *
 */


import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.sql.DriverManager.getConnection;

public final class DateAndTimeUtility {

    static int rec(int n){
        if(n>0){
            return n+ rec(n-1);
        }return -1;
    }



    public static void main(String[] args) {
        int i = 1,j = 10;
        do {
            if(i>j) {
                break;
            }
            j--;
        } while (++i <5);
        System.out.println("i =" +i+" and j = "+j);

        Map<Integer, Integer>[] cnt = new Map[10];
        cnt[1]=new HashMap<>(1);
        var win=new HashMap<Integer,Integer>();
        var set= new HashSet<Integer>();
        var list = new ArrayList<Integer>();
//        list.rem
//var s=new CopyOnWriteArraySet<Integer>();
//        Integer integer = s.stream().max(Comparator.naturalOrder()).get();
//
//        System.out.println((-1<<2)+""+Integer.toString(1,2));
//        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        while (integerList.size()>1){
//            integerList.remove(integerList.size()-1);
//        }

//        System.out.println(integerList);
//        System.out.println(rec(3));
//        System.out.println(DateAndTimeUtility.getDate("2023-01-31").getTime());
//        System.out.println(DateAndTimeUtility.getDate("2022-12-01").getTime());
    }
    // "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000
    //    },
    //    {
    //        "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000
    //    },
    //    {
    //        "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000
    //    },
    //    {
    //        "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000
    //    },
    //    {
    //        "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000
    //    },
    //    {
    //        "vendorId": "RG04",
    //        "productId": "2293480",
    //        "promoInd": "Y",
    //        "quoteEffectiveStartDateString": "2022-08-24",
    //        "quoteEffectiveStartDate": 1661313600000,
    //        "quoteEffectiveEndDateString": "2022-12-31",
    //        "quoteEffectiveEndDate": 1672462800000

    private static final System.Logger LOGGER = null;
    private static final String ERROR_MESSAGE = "DateAndTimeUtils thrown error while parsing date :: ";

    private DateAndTimeUtility(){
        throw new IllegalStateException("Utility class");
    }

    private static SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        return simpleDateFormat;
    }

    private static SimpleDateFormat getSimpleDateFormatWithTimeZoneAndTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        return simpleDateFormat;
    }

    /**
     * This method will return current date in this format "yyyy-MM-dd".
     * @return date
     */
    public static Date getCurrentDate() {
        Date date =null;
        try {
            date = getSimpleDateFormat().parse(getCurrentDateInString());
        } catch (ParseException e) {
//            LOGGER.error("Date and time utils has thrown an error {0}",e);
        }
        return date;
    }

    public static Date getCurrentDateWithTimeStamp() {
        Date date =null;
        try {
            date = getSimpleDateFormatWithTimeZoneAndTimeStamp().parse(getCurrentDateInStringWithTimeStamp());
        } catch (ParseException e) {
//            log.error("Date and time utils has thrown an error {0}",e);
        }
        return date;
    }

    /**
     * This method will return yyyy-MM-dd formatted String date.
     * @return date
     */
    public static String getCurrentDateInString(){
        return getSimpleDateFormat().format(Date.from(Instant.now()));
    }

    public static String getCurrentDateInStringWithTimeStamp(){
        return getSimpleDateFormatWithTimeZoneAndTimeStamp().format(Date.from(Instant.now()));
    }

    /**
     * It will take input as Date and convert into yyyy-MM-dd formatted String date
     * @param date in Date format.
     * @return date
     */
    public static String getStringDateFromDate(Date date){
        return getSimpleDateFormat().format(date);
    }

    /**
     * It will take input as year and month convert into date format with 31st of month.
     * @param year in integer
     * @param month in integer
     * @return date
     */
    public static Date getDateFromYearAndMonth(Number year, Number month) {
        String str = year+"-"+month +"-"+ "31";
        Date date = null;
        try {
            date = getSimpleDateFormat().parse(str);
        } catch (ParseException e) {
//            LOGGER.error(ERROR_MESSAGE, e);
        }
        return date;
    }

    /**
     * It will take input as year and month return yyyy-MM-dd formatted String date with 1st of the month.
     * @param year in integer
     * @param month in integer
     * @return date
     */
    public static String getFirstDayOfTheMonthInYYYYMMDDFormat(Number year, Number month) {
        return year + "-" + String.format("%02d", month.intValue()) + "-" + 1;
    }

    /**
     * It will take input date in long format and return yyy-MM-dd formatted String date.
     * @param date in long
     * @return date
     */
    public static String getDateFromLongDate(long date) {
        return getSimpleDateFormat().format(date);
    }

    /**
     * It will take input as year and month return yyyy-MM-dd formatted String date with last date of the month.
     * @param year in integer
     * @param month in integer
     * @return date
     */
    public static String getLastDayOfTheMonthInYYYYMMDDFormat(Number year, Number month){
        return year + "-" + String.format("%02d", month.intValue()) + "-" +
                YearMonth.of(year.intValue(), month.intValue()).lengthOfMonth();
    }

    /**
     * It will take input as string date in yyyy-mm-dd format and convert into date.
     * @param date yyyy-MM-dd format
     * @return date
     */
    public static Date getDate(String date) {
        Date parsedDate = null;
        try {
            parsedDate = getSimpleDateFormat().parse(date);
        } catch (ParseException e) {
//            LOGGER.error(ERROR_MESSAGE, e);
        }
        return parsedDate;
    }



    /**
     * It will take input as string date in yyyyMMdd format and convert into date.
     * @param date in yyyyMMdd format
     * @return date
     */
    public static Date getDateFromYYYYMMDDFormatWithOutDelimiter(String date){
        SimpleDateFormat simpleDateFormatOld = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormatOld.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date parsedDate = null;
        try {
            parsedDate = simpleDateFormatOld.parse(date);
        } catch (ParseException e) {
//            LOGGER.error(ERROR_MESSAGE, e);
        }
        return parsedDate;
    }

    public static long getCreatedOnDateIgnoringTime(String createdOn){
        Date createdOnDate = DateAndTimeUtility.getDate(
                DateAndTimeUtility.getStringDateFromDate(DateAndTimeUtility.getDateFromCreatedOn(createdOn)));
        if(createdOnDate != null){
            return createdOnDate.getTime();
        }
        return 0L;
    }

    /**
     * It will take input as string date in "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'" or "yyyy-MM-dd hh:mm:ss" format
     * and convert into date.
     * @param createdOn as String
     * @return date
     */
    public static Date getDateFromCreatedOn(String createdOn) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(createdOn);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                parsedDate = formatter.parse(createdOn);
            } catch (ParseException ex) {
//                LOGGER.error(ERROR_MESSAGE, ex);
            }
        }
        return parsedDate;
    }
    private static SimpleDateFormat getSimpleDateFormatWithTimeZoneAndTimeStampZ() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        return simpleDateFormat;
    }
    public static String getCurrentDateInStringWithTimeStampZ(){
        return getSimpleDateFormatWithTimeZoneAndTimeStampZ().format(Date.from(Instant.now()));
    }

    /**
     * It will take input as string date in "yyyy-MM-dd' format and will return LocalDate object.
     * @param inputDate as String
     * @return date as LocalDate
     */
    public static LocalDate getLocalDateFromString(String inputDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(inputDate , formatter);
    }
}


 class Loan {

    int tenure;

    float interestRate;

}

class HomeLoan extends Loan {

    HomeLoan() {

        tenure = 5;  // line m

        interestRate = 8.5f;  //line n

    }

    public static void main(String[] args) {

        Loan loan = new HomeLoan(); // line p
        var v=new HashMap<Integer,Integer>();
        v.put(0,1);
        v.put(1,2);
        System.out.println(v.get(1));


    }

}