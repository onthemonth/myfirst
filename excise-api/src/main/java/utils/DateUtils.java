package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mgq on 2015/11/6.
 */
public class DateUtils {

    public static Date getCurrent(){
        return new Date();
    }

    public static String tranferDate(Date date,String style){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(style);
        try {
            String date1=simpleDateFormat.format(date);

            return date1;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
