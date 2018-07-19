package com.alamkanak.weekview;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public interface WeekViewLoader {

    /**
     * Load the events within the period
     *
     * @param periodIndex the period to load
     * @return A list with the events of this period
     */
    List<? extends WeekViewEvent> onLoad();
}
