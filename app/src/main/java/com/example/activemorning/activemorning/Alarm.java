package com.example.activemorning.activemorning;

public class Alarm {
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
    Boolean[] week = {false,false,false,false,false,false,false};
    Boolean onOff = false;
    public Alarm(String labelName, String time,Day day)
    {
        this.name = labelName;
        this.time = time;
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
    public Alarm(String labelName, String time,Boolean[] week)
    {
        this.name = labelName;
        this.time = time;
        this.week = week;
        this.onOff = true;
    }
    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

}
