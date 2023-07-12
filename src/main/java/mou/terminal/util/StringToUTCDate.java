package mou.terminal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class StringToUTCDate {

    public static Date get(String date){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date newRegDate = null;

        try {
            return dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return null;
    }
}
