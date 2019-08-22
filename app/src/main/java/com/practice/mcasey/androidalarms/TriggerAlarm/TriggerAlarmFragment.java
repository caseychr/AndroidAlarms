package com.practice.mcasey.androidalarms.TriggerAlarm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.practice.mcasey.androidalarms.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TriggerAlarmFragment extends Fragment implements TriggerAlarmView {

    @BindView(R.id.alarm_trigger_current_time) TextView mCurrentTime;
    @BindView(R.id.alarm_trigger_description) TextView mAlarmDescription;
    @BindView(R.id.alarm_trigger_off_btn) Button mAlarmOffBtn;
    View mView;
    TriggerAlarmPresenter mTriggerAlarmPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_trigger_alarm, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTriggerAlarmPresenter = new TriggerAlarmPresenter(mView);
    }

    @Override
    @OnClick (R.id.alarm_trigger_off_btn)
    public void AlarmOffClick() {
        mTriggerAlarmPresenter.AlarmOffClick();
    }
}
