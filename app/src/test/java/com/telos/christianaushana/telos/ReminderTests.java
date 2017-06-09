package com.telos.christianaushana.telos;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ReminderTests {
  @Test
  public void testGetReminderTime() throws Exception {
    Reminder reminder = new Reminder(10, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    assertEquals(reminder.getTime(), 10);
  }

  @Test
  public void testGetReminderTime2() throws Exception {
    Reminder reminder = new Reminder(0, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    assertEquals(reminder.getTime(), 0);
  }

  @Test
  public void testGetReminderMeridiem() throws Exception {
    Reminder reminder = new Reminder(10, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    assertEquals(reminder.getMeridiem(), "AM");
  }

  @Test
  public void testSetReminderTime() throws Exception {
    Reminder reminder = new Reminder(10, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    reminder.setTime(12);
    assertEquals(reminder.getTime(), 12);
  }

  @Test
  public void testSetReminderTime2() throws Exception {
    Reminder reminder = new Reminder(10, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    reminder.setTime(0);
    assertEquals(reminder.getTime(), 10);
  }

  @Test
  public void testSetReminderMeridiem() throws Exception {
    Reminder reminder = new Reminder(10, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, true);
    reminder.setMeridiem("PM");
    assertEquals(reminder.getMeridiem(), "PM");
  }
}