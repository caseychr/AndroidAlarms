package com.practice.mcasey.androidalarms.AlarmList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.practice.mcasey.androidalarms.Alarm.Alarm;
import com.practice.mcasey.androidalarms.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AlarmListFragment extends Fragment {

    @BindView(R.id.alarm_recycler_view) RecyclerView mRecyclerView;
    List<Alarm> mAlarms = new ArrayList<>();
    AlarmRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm_list, container, false);
        ButterKnife.bind(this, view);
        updateView();
        return view;
    }

    private void updateView(){
        createStubData();
        if(mAdapter == null){
            mAdapter = new AlarmRecyclerAdapter(mAlarms);
            mRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.setAlarms(mAlarms);
            mAdapter.notifyDataSetChanged();
        }
        mAdapter.setOnItemClickListener(new AlarmRecyclerAdapter.OnItemClickListener() {
            @Override
            public void setEnableListener(boolean isEnabled) {
                Toast.makeText(getContext(), "ENABLED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick() {
                Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createStubData(){
        Alarm alarm;
        for(int i=0;i<3;i++){
            alarm = new Alarm();
            alarm.setAlarmDescription("alarm_"+i);
            alarm.setTime(Calendar.getInstance().getTimeInMillis());
            mAlarms.add(alarm);
        }
    }
}
