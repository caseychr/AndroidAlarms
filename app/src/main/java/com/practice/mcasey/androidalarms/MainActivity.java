package com.practice.mcasey.androidalarms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.practice.mcasey.androidalarms.AlarmList.AlarmListFragment;
import com.practice.mcasey.androidalarms.CreateAlarm.CreateAlarmFragment;
import com.practice.mcasey.androidalarms.TriggerAlarm.TriggerAlarmFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = new CreateAlarmFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
