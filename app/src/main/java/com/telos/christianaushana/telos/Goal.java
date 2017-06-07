package com.telos.christianaushana.telos;

/**
 * Created by christianaushana on 4/28/17.
 */

public class Goal {
    String name;
    String question;
    String repeatOption; // modify later
    Reminder reminderOption; // modify later

    public Goal() {}

    public Goal(String name, String question, String repeatOption, Reminder reminderOption) {
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

    public void setReminderOption(Reminder reminderOption) {
        this.reminderOption = reminderOption;
    }

    public Reminder getReminderOption() {
        return reminderOption;
    }

}
