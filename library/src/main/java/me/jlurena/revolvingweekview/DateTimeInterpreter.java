package me.jlurena.revolvingweekview;

import org.threeten.bp.DayOfWeek;

/**
 * Created by Raquib on 1/6/2015.
 */
public interface DateTimeInterpreter {
    String interpretDate(DayOfWeek day);

    String interpretTime(int hour, int minutes);
}
