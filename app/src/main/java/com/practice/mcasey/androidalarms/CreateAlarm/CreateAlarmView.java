package com.practice.mcasey.androidalarms.CreateAlarm;

import java.util.Calendar;

public interface CreateAlarmView {

    void pickTime();

    void createDescription();

    void pickDays();

    void createAlarm();

    void displayTime(Calendar calendar);

}
