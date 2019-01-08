package com.example.activemorning.activemorning;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmViewHolder> {

    private List<Alarm> alarmList;
    private LayoutInflater mInflater;
    Context context;
    public  AlarmListAdapter(Context context, LinkedList<Alarm> alarmList){
        mInflater = LayoutInflater.from(context);
        this.alarmList = alarmList;
        this.context = context;
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
        final Alarm currentAlarm = alarmList.get(i);
        final int index = i;
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

//        //+ button clicklistener
//        alarmViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent editInten = new Intent(context,AlarmEditActivity.class);
//                editInten.putExtra("AlarmName",currentAlarm.name);
//                editInten.putExtra("index",index);
//                editInten.putExtra("uur",currentAlarm.uur);
//                editInten.putExtra("minuut",currentAlarm.minuut);
//                editInten.putExtra("mon",currentAlarm.week[0]);
//                editInten.putExtra("tue",currentAlarm.week[1]);
//                editInten.putExtra("wed",currentAlarm.week[2]);
//                editInten.putExtra("thu",currentAlarm.week[3]);
//                editInten.putExtra("fri",currentAlarm.week[4]);
//                editInten.putExtra("sat",currentAlarm.week[5]);
//                editInten.putExtra("sun",currentAlarm.week[6]);
//                context.startActivity(editInten);
//            }
//        });
//        alarmViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alarmList.remove(index);
//                //notifyDataSetChanged();
//            }
//        });
//        //+ switchbutton clicklistener
//        alarmViewHolder.swtOnOff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked)
//                    alarmList.get(index).onOff = true;
//                else
//                    alarmList.get(index).onOff = false;
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }
}
class AlarmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    AlarmListAdapter mAdapter;
    TextView alarmLabel, alarmTime,lblMon,lblTue,lblWed,lblThu,lblFri,lblSat,lblSun;
    Button btnEdit,btnDelete;
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
        btnDelete = itemView.findViewById(R.id.btnDelete);
        this.mAdapter = alarmListAdapter;

    }

    @Override
    public void onClick(View v) {

    }
}