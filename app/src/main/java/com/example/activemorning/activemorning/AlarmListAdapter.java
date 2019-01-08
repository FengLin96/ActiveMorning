package com.example.activemorning.activemorning;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmViewHolder> {

    private List<Alarm> alarmList;
    private LayoutInflater mInflater;

    public  AlarmListAdapter(Context context, LinkedList<Alarm> alarmList){
        mInflater = LayoutInflater.from(context);
        this.alarmList = alarmList;
    }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate an item view
        View mItemView = mInflater.inflate(R.layout.alarmlist,viewGroup,false);

        return new AlarmViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder alarmViewHolder, int i) {
        // Retrieve the data for that position
        Alarm currentAlarm = alarmList.get(i);

        //add data to the view
        alarmViewHolder.alarmLabel.setText(currentAlarm.name);
        alarmViewHolder.alarmTime.setText(currentAlarm.time);
        if(currentAlarm.onOff)
            alarmViewHolder.swtOnOff.setChecked(true);
        else
            alarmViewHolder.swtOnOff.setChecked(false);

        if(currentAlarm.week[0])
            alarmViewHolder.lblMon.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblMon.setTextColor(Color.GRAY);

        if(currentAlarm.week[1])
            alarmViewHolder.lblTue.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblTue.setTextColor(Color.GRAY);

        if(currentAlarm.week[2])
            alarmViewHolder.lblWed.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblWed.setTextColor(Color.GRAY);

        if(currentAlarm.week[3])
            alarmViewHolder.lblThu.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblThu.setTextColor(Color.GRAY);

        if(currentAlarm.week[4])
            alarmViewHolder.lblFri.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblFri.setTextColor(Color.GRAY);

        if(currentAlarm.week[5])
            alarmViewHolder.lblSat.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblSat.setTextColor(Color.GRAY);

        if(currentAlarm.week[6])
            alarmViewHolder.lblSun.setTextColor(Color.BLUE);
        else
            alarmViewHolder.lblSun.setTextColor(Color.GRAY);

        //+ button clicklistener

        //+ switchbutton clicklistener

    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }
}
class AlarmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    AlarmListAdapter mAdapter;
    TextView alarmLabel, alarmTime,lblMon,lblTue,lblWed,lblThu,lblFri,lblSat,lblSun;
    Button btnEdit;
    Switch swtOnOff;
    public AlarmViewHolder(@NonNull View itemView, AlarmListAdapter alarmListAdapter) {
        super(itemView);
        alarmLabel = itemView.findViewById(R.id.alarmLabel);
        alarmTime = itemView.findViewById(R.id.alarmTime);
        lblMon = itemView.findViewById(R.id.lblMon);
        lblTue = itemView.findViewById(R.id.lblTue);
        lblWed = itemView.findViewById(R.id.lblWed);
        lblThu = itemView.findViewById(R.id.lblThu);
        lblFri = itemView.findViewById(R.id.lblFri);
        lblSat = itemView.findViewById(R.id.lblSat);
        lblSun = itemView.findViewById(R.id.lblSun);
        swtOnOff = itemView.findViewById(R.id.btnSwitch);

        this.mAdapter = alarmListAdapter;

    }

    @Override
    public void onClick(View v) {

    }
}