package me.kamili.rachid.nearbyeventsapp.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    public static String toMonthName3L(String dateString){
        Date date=toDate(dateString);
        return new DateFormatSymbols().getMonths()[date.getMonth()].substring(0,3).toUpperCase();
    }

    public static String toDay(String dateString){
        Date date=toDate(dateString);
        return ""+date.getDate();
    }

    private static Date toDate(String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        Date date=null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return date;
    }
}
