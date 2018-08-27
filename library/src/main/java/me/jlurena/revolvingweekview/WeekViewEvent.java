package me.jlurena.revolvingweekview;

import android.graphics.Shader;
import android.support.annotation.ColorInt;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raquib-ul-Alam Kanak on 7/21/2014.
 * Website: http://april-shower.com
 */
public class WeekViewEvent {
    private String mId;
    private DayTime mStartTime;
    private DayTime mEndTime;
    private String mName;
    private String mLocation;
    private @ColorInt int mColor;
    private boolean mAllDay;
    private Shader mShader;

    public WeekViewEvent() {

    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event as String.
     * @param name Name of the event.
     * @param startDay Day when the event starts.
     * @param startHour Hour (in 24-hour format) when the event starts.
     * @param startMinute Minute when the event starts.
     * @param endDay Day when the event ends.
     * @param endHour Hour (in 24-hour format) when the event ends.
     * @param endMinute Minute when the event ends.
     */
    public WeekViewEvent(String id, String name, int startDay, int startHour, int startMinute, int endDay, int
            endHour, int endMinute) {
        this.mId = id;

        this.mStartTime = new DayTime(startDay, startHour, startMinute);
        this.mEndTime = new DayTime(endDay, endHour, endMinute);

        this.mName = name;
    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event as String.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     * @param allDay Is the event an all day event.
     * @param shader the Shader of the event rectangle
     */
    public WeekViewEvent(String id, String name, String location, DayTime startTime, DayTime endTime, boolean allDay,
            Shader shader) {
        this.mId = id;
        this.mName = name;
        this.mLocation = location;
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mAllDay = allDay;
        this.mShader = shader;
    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     * @param allDay Is the event an all day event.
     * @param shader the Shader of the event rectangle
     */
    @Deprecated
    public WeekViewEvent(long id, String name, String location, DayTime startTime, DayTime endTime, boolean allDay,
            Shader shader) {
        this(String.valueOf(id), name, location, startTime, endTime, allDay, shader);
    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event as String.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     * @param allDay Is the event an all day event
     */
    public WeekViewEvent(String id, String name, String location, DayTime startTime, DayTime endTime, boolean
            allDay) {
        this(id, name, location, startTime, endTime, allDay, null);
    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event as String.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    public WeekViewEvent(String id, String name, String location, DayTime startTime, DayTime endTime) {
        this(id, name, location, startTime, endTime, false);
    }

    /**
     * Initializes the event for week view.
     *
     * @param id The id of the event specified as String.
     * @param name Name of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    public WeekViewEvent(String id, String name, DayTime startTime, DayTime endTime) {
        this(id, name, null, startTime, endTime);
    }

    public @ColorInt
    int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public DayTime getEndTime() {
        return mEndTime;
    }

    public void setEndTime(DayTime endTime) {
        this.mEndTime = endTime;
    }

    public String getIdentifier() {
        return mId;
    }

    public void setIdentifier(String id) {
        this.mId = id;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Shader getShader() {
        return mShader;
    }

    public void setShader(Shader shader) {
        mShader = shader;
    }

    public DayTime getStartTime() {
        return mStartTime;
    }

    public void setStartTime(DayTime startTime) {
        this.mStartTime = startTime;
    }

    public boolean isAllDay() {
        return mAllDay;
    }

    public void setAllDay(boolean allDay) {
        this.mAllDay = allDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WeekViewEvent that = (WeekViewEvent) o;

        return mId.equals(that.mId);
    }

    @Override
    public int hashCode() {
        return mId.hashCode();
    }

    public List<WeekViewEvent> splitWeekViewEvents() {
        //This function splits the WeekViewEvent in WeekViewEvents by day
        List<WeekViewEvent> events = new ArrayList<>();
        DayTime endTime = new DayTime(this.mEndTime);
        if (this.mStartTime.getDay() != endTime.getDay()) {
            endTime = new DayTime(this.mStartTime.getDay(), LocalTime.MAX);
            WeekViewEvent event1 = new WeekViewEvent(this.mId, this.mName, this.mLocation, this.mStartTime, endTime,
                    this.mAllDay);
            event1.setColor(this.mColor);
            events.add(event1);

            // Add other days.
            DayTime otherDay = new DayTime(DayOfWeek.of(1), this.mStartTime.getTime());
            while (otherDay.getDay() != this.mEndTime.getDay()) {
                DayTime overDay = new DayTime(otherDay.getDay(), LocalTime.MIN);
                DayTime endOfOverDay = new DayTime(overDay.getDay(), LocalTime.MAX);
                WeekViewEvent eventMore = new WeekViewEvent(this.mId, this.mName, null, overDay, endOfOverDay, this
                        .mAllDay);
                eventMore.setColor(this.getColor());
                events.add(eventMore);

                // Add next day.
                otherDay.addDays(1);
            }

            // Add last day.
            DayTime startTime = new DayTime(this.mEndTime.getDay(), LocalTime.MIN);
            WeekViewEvent event2 = new WeekViewEvent(this.mId, this.mName, this.mLocation, startTime, this.mEndTime,
                    this.mAllDay);
            event2.setColor(this.getColor());
            events.add(event2);
        } else {
            events.add(this);
        }

        return events;
    }

    @Override
    public String toString() {
        return "WeekViewEvent{" +
                "mId='" + mId + '\'' +
                ", mStartTime=" + mStartTime +
                ", mEndTime=" + mEndTime +
                ", mName='" + mName + '\'' +
                ", mLocation='" + mLocation + '\'' +
                '}';
    }
}
