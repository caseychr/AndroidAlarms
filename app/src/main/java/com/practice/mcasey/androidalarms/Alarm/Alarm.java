package com.practice.mcasey.androidalarms.Alarm;

public class Alarm {

    private String mAlarmDescription;
    private long mTime;
    private String mDays;
    private boolean mEnabled;
    private boolean mRecurring;

    public String getAlarmDescription() {
        return mAlarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        mAlarmDescription = alarmDescription;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getDays() {
        return mDays;
    }

    public void setDays(String days) {
        mDays = days;
    }

    public boolean isEnabled() {
        return mEnabled;
    }

    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    public boolean isRecurring() {
        return mRecurring;
    }

    public void setRecurring(boolean recurring) {
        mRecurring = recurring;
    }
}
