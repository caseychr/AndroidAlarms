package com.practice.mcasey.androidalarms.sql;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.practice.mcasey.androidalarms.Alarm.Alarm;

public class AlarmCursorWrapper extends CursorWrapper {

    public AlarmCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Alarm getAlarm(){
        String alarmDescriptionString = getString(getColumnIndex(AlarmDBSchema.AlarmTable.Cols.ALARM_DESCRIPTION));
        long alarmTime = getLong(getColumnIndex(AlarmDBSchema.AlarmTable.Cols.ALARM_TIME));
        String alarmDaysString = getString(getColumnIndex(AlarmDBSchema.AlarmTable.Cols.ALARM_DAYS));
        int alarmIsRecurring = getInt(getColumnIndex(AlarmDBSchema.AlarmTable.Cols.ALARM_RECURRING));
        int alarmIsEnabled = getInt(getColumnIndex(AlarmDBSchema.AlarmTable.Cols.ALARM_ENABLED));

        Alarm alarm = new Alarm();
        alarm.setAlarmDescription(alarmDescriptionString);
        alarm.setTime(alarmTime);
        alarm.setDays(alarmDaysString);
        alarm.setRecurring(alarmIsRecurring != 0);
        alarm.setEnabled(alarmIsEnabled != 0);

        return alarm;
    }
}
