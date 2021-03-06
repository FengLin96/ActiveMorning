package com.example.activemorning.activemorning;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 3 ;
    LinkedList<Alarm> alarmList = new LinkedList<Alarm>();
    RecyclerView mRecyclerView;
    AlarmListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycleView);
        mAdapter = new AlarmListAdapter(this, alarmList);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Voeg nieuwe alarm
        FloatingActionButton btnAddNewAlarm = (FloatingActionButton) findViewById(R.id.btnAddAlarm);
        btnAddNewAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddNewAlarm = new Intent(MainActivity.this, activity_setAlarm.class);
                startActivityForResult(AddNewAlarm,3); //3 = TEXT_REQUEST
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String alarmName = data.getStringExtra("Alarm name");
                int minuut = data.getIntExtra("Minuut",Calendar.MINUTE);
                int uur = data.getIntExtra("Uur",Calendar.HOUR);
                boolean mon = data.getBooleanExtra("mon",false);
                boolean tue = data.getBooleanExtra("tue",false);
                boolean wed = data.getBooleanExtra("wed",false);
                boolean thu = data.getBooleanExtra("thu",false);
                boolean fri = data.getBooleanExtra("fri",false);
                boolean sat = data.getBooleanExtra("sat",false);
                boolean sun = data.getBooleanExtra("sun",false);
                // process data

                Boolean[] week = {mon,tue,wed,thu,fri,sat,sun};


                alarmList.add(new Alarm(alarmName,Integer.toString(uur),Integer.toString(minuut),week));
                Log.i("alarmList", Integer.toString(alarmList.size()));
                Log.i("minuut", Integer.toString(minuut));
                Log.i("uur",Integer.toString(uur));

                mAdapter.notifyDataSetChanged();

                AlarmManager am = (AlarmManager) this.getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,uur);
                calendar.set(Calendar.MINUTE, minuut);
                Intent intent = new Intent(MainActivity.this,Alarm.class);
                PendingIntent ringIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
                am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),ringIntent);

                //int interval = (int) intent.getLongExtra("intervalMillis", 0);
                //am.setWindow(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),,interval);
            }
        }
    }

}