package ch.sylvainmuller.utility;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

public class Utility {

    /**
     * Create new date "yyyy" from int
     * @param year
     * @return
     */
    public static Date intYearToYearDate(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * Check if string is numeric value (generally from textfield)
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

}
