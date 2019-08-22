package com.practice.mcasey.androidalarms.CreateAlarm;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import com.practice.mcasey.androidalarms.AlarmList.AlarmListFragment;
import com.practice.mcasey.androidalarms.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAlarmFragment extends Fragment implements CreateAlarmView {

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

    CreateAlarmPresenter mCreateAlarmPresenter;
    LayoutInflater mLayoutInflater;
    ViewGroup mViewGroup;
    View mView;
    View mDayPickerView;
    View mTimePickerView;
    PopupWindow mTimePickerPopupWindow;
    PopupWindow mDayPickerPopupWindow;
    Calendar mCalendar;

    @BindView(R.id.create_alarm_time_tv) TextView mTime;
    @BindView(R.id.create_alarm_description_et) EditText mDescription;
    @BindView(R.id.create_alarm_days_tv) TextView mDays;
    @BindView(R.id.create_alarm_btn) Button mCreateBtn;

    Button mTimeCancelBtn;
    Button mTimeOkBtn;
    Button mDaysCancelBtn;
    Button mDaysOkBtn;
    TimePicker mTimePicker;
    RecyclerView mRecyclerView;
    DaysRecyclerAdapter mAdapter;

    @Override
    public void onResume() {
        super.onResume();
        mCreateAlarmPresenter = new CreateAlarmPresenter(mView);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        mViewGroup = container;
        mCalendar = Calendar.getInstance();
        mView = mLayoutInflater.inflate(R.layout.fragment_create_alarm, mViewGroup, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    @OnClick (R.id.create_alarm_time_tv)
    public void pickTime() {
        mTimePickerView = mLayoutInflater.inflate(R.layout.popup_time_picker, mViewGroup, false);
        mTimePickerPopupWindow = new PopupWindow(mTimePickerView, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mTimePicker = mTimePickerView.findViewById(R.id.time_picker_popup);
        mTimeCancelBtn = mTimePickerView.findViewById(R.id.time_picker_cancel_btn);
        mTimeCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCreateAlarmPresenter.cancelTimePicker(mTimePickerPopupWindow);
                mTimePickerPopupWindow.dismiss();
            }
        });
        mTimeOkBtn = mTimePickerView.findViewById(R.id.time_picker_ok_btn);
        mTimeOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendar = mCreateAlarmPresenter.confirmTimePicker(mTimePicker);
                displayTime(mCalendar);
                mTimePickerPopupWindow.dismiss();
            }
        });
        mTimePickerPopupWindow.showAtLocation(mView, Gravity.CENTER, 0, 0);
    }

    @Override
    public void createDescription() {

    }

    @Override
    @OnClick (R.id.create_alarm_days_tv)
    public void pickDays() {
        mDayPickerView = mLayoutInflater.inflate(R.layout.popup_day_picker, mViewGroup, false);
        mDayPickerPopupWindow = new PopupWindow(mDayPickerView, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mRecyclerView = mDayPickerView.findViewById(R.id.day_list_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(mAdapter == null){
            mAdapter = new DaysRecyclerAdapter(mCreateAlarmPresenter.sDays);
            mRecyclerView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(new DaysRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick() {

            }
        });
        mDaysCancelBtn = mDayPickerView.findViewById(R.id.days_cancel_btn);
        mDaysCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCreateAlarmPresenter.cancelDaysPicker(mDayPickerPopupWindow);
                mDayPickerPopupWindow.dismiss();
            }
        });
        mDaysOkBtn = mDayPickerView.findViewById(R.id.days_ok_btn);
        mDaysOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCreateAlarmPresenter.confirmDaysPicker(mDayPickerPopupWindow);
                mDayPickerPopupWindow.dismiss();
            }
        });
        mDayPickerPopupWindow.showAtLocation(mView, Gravity.CENTER, 0, 0);
    }

    @Override
    @OnClick (R.id.create_alarm_btn)
    public void createAlarm() {
        mCreateAlarmPresenter.completeAlarmCreation(mCalendar.getTimeInMillis(), mDescription.getText().toString(),
                mDays.getText().toString());
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new AlarmListFragment()).commit();
    }

    @Override
    public void displayTime(Calendar calendar) {
        mTime.setText(timeFormat.format(calendar.getTime()));
    }
}
