package com.practice.mcasey.androidalarms.CreateAlarm;


import android.view.View;
import android.widget.PopupWindow;
import android.widget.TimePicker;

import com.practice.mcasey.androidalarms.Alarm.Alarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateAlarmPresenter {

    private static final int ZERO_SECONDS = 00;

    public List<String> sDays = new ArrayList<>();
    private Calendar mCalendar = Calendar.getInstance();
    View mView;

    public CreateAlarmPresenter(View view) {
        mView = view;
        addDays();
    }

    public void completeAlarmCreation(long time, String description, String days){
        Alarm alarm = new Alarm();
        alarm.setTime(time);
        alarm.setAlarmDescription(description);
        alarm.setDays(days);
        //alarm.setRecurring(alarm.getDays()!= null ? 1:0);
        alarm.setEnabled(true);
    }

    public void cancelTimePicker(PopupWindow popupWindow){
    }

    public Calendar confirmTimePicker(TimePicker timePicker){
        mCalendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        mCalendar.set(Calendar.MINUTE, timePicker.getMinute());
        mCalendar.set(Calendar.SECOND, ZERO_SECONDS);
        return mCalendar;
    }

    public void cancelDaysPicker(PopupWindow popupWindow){

    }

    public void confirmDaysPicker(PopupWindow popupWindow){

    }

    public void addDays(){
        sDays.add("Sunday");sDays.add("Monday");
        sDays.add("Tuesday");sDays.add("Wednesday");
        sDays.add("Thursday");sDays.add("Friday");
        sDays.add("Saturday");
    }
}
