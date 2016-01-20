package com.excise.requestion.basic.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mgq on 2016/1/12.
 */
public class DateUtil {

    @Test
    public void testCal() throws Exception{
        //Date appointDate= new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse("2016-01-13");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        System.out.println(intWeek-1<0?6:intWeek-1);
    }
}
