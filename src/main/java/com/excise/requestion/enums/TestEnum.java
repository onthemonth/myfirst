package com.excise.requestion.enums;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mgq on 2015/12/9.
 */
public class TestEnum {

    public static void main(String[] args)throws Exception{
        System.out.println(ResponseCode.F400.getCode());
        System.out.println(ResponseCode.F400.getMesage());
        System.out.println(ResponseCode.getResponseCode(402));
        System.out.println(ResponseCode.values().toString());

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=simpleDateFormat.parse("9999-12-31 23:59:59");
        System.out.println(simpleDateFormat.format(date));

        System.out.println(date.toString());
        Calendar calendar=Calendar.getInstance();
        //calendar.setTime(new Date("9999:99:99 99:"));

    }
}
