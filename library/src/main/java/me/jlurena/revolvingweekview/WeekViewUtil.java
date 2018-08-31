package me.jlurena.revolvingweekview;

import org.threeten.bp.DayOfWeek;

public class WeekViewUtil {

    /**
     * {@link DayOfWeek} day of week integer value to {@link java.util.Calendar#DAY_OF_WEEK} integer value.
     *
     * @param dayOfWeek The {@link DayOfWeek} integer value representing the day of the week.
     * @return Integer value representing Day Of Week per {@link java.util.Calendar} standards.
     */
    public static int dayOfWeekToCalendarDay(int dayOfWeek) {
        return dayOfWeek % 7 + 1;
    }

    /**
     * {@link java.util.Calendar#DAY_OF_WEEK} integer value to {@link DayOfWeek} integer value.
     * @param calendarDay The {@link java.util.Calendar} integer value representing the day of the week.
     * @return The correct {@link DayOfWeek} integer value.
     */
    public static int calendarDayToDayOfWeek(int calendarDay) {
        return calendarDay == 1 ? 7 : calendarDay - 1;
    }

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

    /*
     * Returns the amount of minutes passed in the day before the time in the given date
     * @param date
     * @return amount of minutes in day before time
     */
    public static int getPassedMinutesInDay(DayTime date) {
        return getPassedMinutesInDay(date.getHour(), date.getMinute());
    }
}
