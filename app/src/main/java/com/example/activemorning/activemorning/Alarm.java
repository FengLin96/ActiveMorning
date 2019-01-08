package com.example.activemorning.activemorning;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService; //misschien hier een probleem
import static android.support.v4.content.ContextCompat.startActivities;

public class Alarm extends BroadcastReceiver{

    public enum Day
    {
         MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    String name;
    String time;
    String uur;
    String minuut;
    Boolean[] week = {false,false,false,false,false,false,false};
    Boolean onOff = false;
    public Alarm()
    {

    }
    public Alarm(String labelName, String uur,String minuut,Day day)
    {
        this.name = labelName;
        this.time = uur+":"+minuut;
        this.uur = uur;
        this.minuut = minuut;
        switch (day)
        {
            case MONDAY: week[0] = true;
            case TUESDAY: week[1] = true;
            case WEDNESDAY: week[2] = true;
            case THURSDAY: week[3] = true;
            case FRIDAY: week[4] = true;
            case SATURDAY: week[5]= true;
            case SUNDAY: week[6] = true;
        }
        this.onOff = true;
    }
    public Alarm(String labelName, String uur,String minuut,Boolean[] week)
    {
        this.name = labelName;
        this.week = week;
        this.onOff = true;

        this.time = uur+":"+minuut;
        this.uur = uur;
        this.minuut = minuut;
    }
    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm........",Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        StepCountFunction stepCountFunction = new StepCountFunction(context);
        stepCountFunction.registerSensor();
        stepCountFunction.initListener();
        if (stepCountFunction.TotaalStep != 20)
        {
            vibrator.vibrate(300000);
        }
        else
        {
            stepCountFunction.unregisterSensor(context);
        }


//        Intent ringIntent = new Intent(context, RingActivity.class);
//        context.startActivity(ringIntent);
    }
}
