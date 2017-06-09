package com.telos.christianaushana.telos;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ReminderTests {
  Reminder reminder = new Reminder(10, "AM");
  Goal goal = new Goal("Run", "Did you run today?", "daily", reminder, true);

  @Test
  public void testGetReminderTime() throws Exception {
    assertEquals(reminder.getTime(), 10);
  }

  @Test
  public void testGetReminderMeridiem() throws Exception {
    assertEquals(reminder.getMeridiem(), "AM");
  }

  @Test
  public void testSetReminderTime() throws Exception {
    reminder.setTime(12);
    assertEquals(reminder.getTime(), 12);
  }

  @Test
  public void testSetReminderMeridiem() throws Exception {
    reminder.setMeridiem("PM");
    assertEquals(reminder.getMeridiem(), "PM");
  }
}