package com.practice.mcasey.androidalarms.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.practice.mcasey.androidalarms.sql.AlarmDBSchema.AlarmTable;

public class AlarmBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "alarmBase.db";

    public AlarmBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ AlarmTable.NAME+"("+
                "_id integer primary key autoincrement, "+
                AlarmTable.Cols.ALARM_DESCRIPTION+", "+
                AlarmTable.Cols.ALARM_TIME+", "+
                AlarmTable.Cols.ALARM_DAYS+", "+
                AlarmTable.Cols.ALARM_ENABLED+", "+
                AlarmTable.Cols.ALARM_RECURRING+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
