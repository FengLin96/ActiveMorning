package com.example.activemorning.activemorning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class activity_setAlarm extends AppCompatActivity {

    public final static String EXTRA_RETURN_MESSAGE =
            "RETURN_MESSAGE";
    private int intUur, intMinuut;
    private String strAlarmName;
    private boolean mon,tue,wed,thu,fri,sat,sun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        final Calendar calendar = Calendar.getInstance();
        intUur = calendar.get(Calendar.HOUR);
        intMinuut = calendar.get(Calendar.MINUTE);

        strAlarmName = "Alarm";
        Button btnSaveAlarm = (Button) findViewById(R.id.btnSave);
        TimePicker tp = (TimePicker) findViewById(R.id.tp);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                intUur = hourOfDay;
                intMinuut = minute;
            }
        });

        btnSaveAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextAlarm);
                strAlarmName = editText.getText().toString();

                CheckBox cboxMon = (CheckBox) findViewById(R.id.cboxMon);
                mon = cboxMon.isChecked();

                CheckBox cboxTue = (CheckBox) findViewById(R.id.cboxTue);
                tue = cboxTue.isChecked();

                CheckBox cboxWed = (CheckBox) findViewById(R.id.cboxWed);
                wed = cboxMon.isChecked();

                CheckBox cboxThu = (CheckBox) findViewById(R.id.cboxThu);
                thu = cboxThu.isChecked();

                CheckBox cboxFri = (CheckBox) findViewById(R.id.cboxFri);
                fri = cboxFri.isChecked();

                CheckBox cboxSat = (CheckBox) findViewById(R.id.cboxSat);
                sat = cboxSat.isChecked();

                CheckBox cboxSun = (CheckBox) findViewById(R.id.cboxSun);
                sun = cboxSun.isChecked();

                Intent returnIntent = new Intent();

               returnIntent.putExtra("Alarm name",strAlarmName);
               returnIntent.putExtra("Uur", intUur);
               returnIntent.putExtra("Minuut", intMinuut);
               returnIntent.putExtra("mon",mon);
                returnIntent.putExtra("tue",tue);
                returnIntent.putExtra("wed",wed);
                returnIntent.putExtra("thu",thu);
                returnIntent.putExtra("fri",fri);
                returnIntent.putExtra("sat",sat);
                returnIntent.putExtra("sun",sun);

                setResult(RESULT_OK,returnIntent);

                finish();
            }
        });
    }
}
