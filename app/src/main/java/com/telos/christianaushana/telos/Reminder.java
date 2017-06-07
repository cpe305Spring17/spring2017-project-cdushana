package com.telos.christianaushana.telos;

/**
 * Created by christianaushana on 5/2/17.
 */

public class Reminder {
    int time;
    String meridiem;

    public Reminder(int time, String meridiem) {
        if (time >= 1 && time <= 12) {
            this.time = time;
        }

        this.meridiem = meridiem;
    }

    public int getTime() {
        return time;
    }

    public String getMeridiem() {
        return meridiem;
    }

    public void setTime(int time) {
        if (time >= 1 && time <= 12) {
            this.time = time;
        }
        this.time = time;
    }

    public void setMeridiem(String meridiem) {
        this.meridiem = meridiem;
    }
}
