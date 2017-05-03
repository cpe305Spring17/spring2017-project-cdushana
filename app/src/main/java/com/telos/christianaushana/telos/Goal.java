package com.telos.christianaushana.telos;

import android.provider.CalendarContract;

/**
 * Created by christianaushana on 4/28/17.
 */

public class Goal {
    String name;
    String question;
    String repeatOption; // modify later
    String reminderOption; // modify later

    public Goal() {}

    public Goal(String name, String question, String repeatOption, String reminderOption) {
        this.name = name;
        this.question = question;
        this.repeatOption = repeatOption;
        this.reminderOption = reminderOption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setRepeatOption(String repeatOption) {
        this.repeatOption = repeatOption;
    }

    public String getRepeatOption() {
        return repeatOption;
    }

    public void setReminderOption(String reminderOption) {
        this.reminderOption = reminderOption;
    }

    public String getReminderOption() {
        return reminderOption;
    }

}
