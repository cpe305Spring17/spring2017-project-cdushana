package com.telos.christianaushana.telos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by christianaushana on 4/28/17.
 */

public class Goal {
  String name;
  String question;
  Reminder reminderOption;
  Boolean status = false;

  public Goal() {}

  public Goal(String name, String question, String repeatOption, Reminder reminderOption, Boolean status) {
    this.name = name;
    this.question = question;
    this.reminderOption = reminderOption;
    this.status = status;
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

  public void setReminderOption(Reminder reminderOption) {
      this.reminderOption = reminderOption;
  }

  public Reminder getReminderOption() {
      return reminderOption;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
