package utils.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CalendarDates {
    public CalendarDates(){

    }
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println("Today's date is "+ dateFormat.format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        String yesterday = dateFormat.format(cal.getTime());
        System.out.println("Yesterday's date was " + yesterday);
        return yesterday;
    }

    public static String getYesterdayDateFormatWithDash() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today's date is "+ dateFormat.format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        String yesterdayDashed = dateFormat.format(cal.getTime());
        System.out.println("Yesterday's date was " + yesterdayDashed);
        return yesterdayDashed;
    }

    /**
     * Function to retrieve sysdate using Instant.now() class
     * @return return the sysdate with specified format: "yyyy-MM-ddTHH:mm:ss:SSSZ"
     */
    public static String getTodayAsSysdate(){
        Instant instant = Instant.now();
        ZoneId z = ZoneId.of( "Europe/Paris" );
        ZonedDateTime zdt = instant.atZone( z );
        System.out.println("zdt before update = " + zdt);
        String todayAsSysdate = zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T" + zdt.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + "Z";
        System.out.println("today's date as sysdate is " + todayAsSysdate);
        return todayAsSysdate;
    }
    public static String getCalculationDateAsSysdate(String date) throws ParseException {
        SimpleDateFormat calculationDateFormatter = new SimpleDateFormat("yyyyMMdd");
        Date calculationDate=calculationDateFormatter.parse(date);
        Instant calculationDateInstant = calculationDate.toInstant();
        ZoneId z = ZoneId.of( "Europe/Paris" );
        ZonedDateTime zdt = calculationDateInstant.atZone( z );
        System.out.println("zdt before update = " + zdt);
        String calculationDateString = zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T" + zdt.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + "Z";
        System.out.println("Calculation's date as sysdate is " + calculationDateString);
        return calculationDateString;
    }
}
