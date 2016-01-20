package com.excise.requestion.little;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mgq on 2015/12/2.
 */
public class DateDemo {

    public static void main(String[] args){
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
        Date date=curr.getTime();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String dateString=simpleDateFormat.format(date);
        System.out.println(dateString);
    }

}
