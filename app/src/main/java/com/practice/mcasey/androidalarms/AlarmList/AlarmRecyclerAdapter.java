package com.practice.mcasey.androidalarms.AlarmList;

import static android.widget.CompoundButton.*;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.practice.mcasey.androidalarms.Alarm.Alarm;
import com.practice.mcasey.androidalarms.R;

import java.util.List;

public class AlarmRecyclerAdapter extends RecyclerView.Adapter<AlarmRecyclerAdapter.ViewHolder>{

    public interface OnItemClickListener{
        void setEnableListener(boolean isEnabled);
        void onClick();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    private List<Alarm> mAlarms;
    private OnItemClickListener mOnItemClickListener;

    public AlarmRecyclerAdapter(List<Alarm> alarms){mAlarms = alarms;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_alarm, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Alarm data = mAlarms.get(i);
        viewHolder.mTimeTV.setText(String.valueOf(data.getTime()));
        viewHolder.mDescriptionTV.setText(String.valueOf(data.getAlarmDescription()));
        viewHolder.mRecurringDaysTV.setText(String.valueOf(data.getDays()));
        viewHolder.mEnabled.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mOnItemClickListener.setEnableListener(b);
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlarms.size();
    }

    public void setAlarms(List<Alarm> alarms){mAlarms = alarms;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTimeTV;
        private TextView mDescriptionTV;
        private TextView mRecurringDaysTV;
        private Switch mEnabled;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTimeTV = itemView.findViewById(R.id.tv_list_time);
            mDescriptionTV = itemView.findViewById(R.id.tv_list_description);
            mRecurringDaysTV = itemView.findViewById(R.id.tv_list_day);
            mEnabled = itemView.findViewById(R.id.switch_list_enabled);
        }
    }
}
