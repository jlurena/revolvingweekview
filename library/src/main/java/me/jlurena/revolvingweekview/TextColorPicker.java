package me.jlurena.revolvingweekview;

import android.support.annotation.ColorInt;

public interface TextColorPicker {

    @ColorInt
    int getTextColor(WeekViewEvent event);

}
