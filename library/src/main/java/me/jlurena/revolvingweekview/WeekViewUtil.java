package me.jlurena.revolvingweekview;

import org.threeten.bp.DayOfWeek;

/**
 * Created by jesse on 6/02/2016.
 */
public class WeekViewUtil {


    /////////////////////////////////////////////////////////////////
    //
    //      Helper methods.
    //
    /////////////////////////////////////////////////////////////////

    /**
     * Returns the amount of days between the second date and the first date
     *
     * @param dateOne the first date
     * @param dateTwo the second date
     * @return the amount of days between dateTwo and dateOne
     */
    public static int daysBetween(DayOfWeek dateOne, DayOfWeek dateTwo) {
        int daysInBetween = 0;
        while (dateOne != dateTwo) {
            daysInBetween++;
            dateOne = dateOne.plus(1);
        }
        return daysInBetween;
    }

    /*
     * Returns the amount of minutes passed in the day before the time in the given date
     * @param date
     * @return amount of minutes in day before time
     */
    public static int getPassedMinutesInDay(DayTime date) {
        return getPassedMinutesInDay(date.getHour(), date.getMinute());
    }

    /**
     * Returns the amount of minutes in the given hours and minutes
     *
     * @param hour Number of hours
     * @param minute Number of minutes
     * @return amount of minutes in the given hours and minutes
     */
    public static int getPassedMinutesInDay(int hour, int minute) {
        return hour * 60 + minute;
    }
}
