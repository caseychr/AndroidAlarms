package com.practice.mcasey.androidalarms.sql;

public class AlarmDBSchema {

    public static final class AlarmTable{
        public static final String NAME = "alarms";

        public static final class Cols{
            public static final String ALARM_DESCRIPTION = "alarm_description";
            public static final String ALARM_TIME = "alarm_time";
            public static final String ALARM_DAYS = "alarm_days";
            public static final String ALARM_ENABLED = "alarm_enabled";
            public static final String ALARM_RECURRING = "alarm_recurring";
        }
    }
}
