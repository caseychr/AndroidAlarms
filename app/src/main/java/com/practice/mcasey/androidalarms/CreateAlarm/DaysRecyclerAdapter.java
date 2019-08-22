package com.practice.mcasey.androidalarms.CreateAlarm;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.practice.mcasey.androidalarms.R;

public class DaysRecyclerAdapter extends RecyclerView.Adapter<DaysRecyclerAdapter.ViewHolder>{

    List<String> mDays;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClick();
    }

    public DaysRecyclerAdapter(List<String> days){mDays = days;}

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){mOnItemClickListener = onItemClickListener;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_day, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        String day = mDays.get(i);
        viewHolder.mDayTextView.setText(day);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewHolder.mIsChecked){
                    viewHolder.mCheckBox.setVisibility(View.INVISIBLE);
                    viewHolder.mIsChecked = false;
                }else{
                    viewHolder.mCheckBox.setVisibility(View.VISIBLE);
                    viewHolder.mIsChecked = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mDayTextView;
        public ImageView mCheckBox;
        public boolean mIsChecked;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mDayTextView = itemView.findViewById(R.id.day_tv);
            mCheckBox = itemView.findViewById(R.id.day_checkbox);
            mCheckBox.setVisibility(View.INVISIBLE);
        }
    }
}
