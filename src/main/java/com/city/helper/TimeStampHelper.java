package com.city.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @deprecation 时间戳助手函数
 * @email leichuqiao@126.com
 * @author 雷楚桥
 * @date 2018-06-14 19:53
 */
public class TimeStampHelper {

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    public static String stampToDate(String s){
        return stampToDate(s,0);
    }

    public static String stampToDate(String s,Integer type){

        String pattern = "";
        if(type == 0)
            pattern = "yyyy-MM-dd HH:mm:ss";
        else if(type == 1){
            pattern = "yyyy-MM-dd";
        }
        String res;
        if("".equals(s) || s == null)
            return "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        long lt = new Long(s + "000");
        Date date = new Date(lt);

        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getTimeStamp(){
        long timeMillis = System.currentTimeMillis();
        return timeMillis/1000 + "";
    }
}
