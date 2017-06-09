package com.telos.christianaushana.telos;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GoalTests {

  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }

  @Test
  public void testGoalName() throws Exception {
    Reminder reminder = new Reminder(1, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, false);
    assertEquals(goal.getName(), "Run");
  }

  @Test
  public void testSetGoalName() throws Exception {
    Reminder reminder = new Reminder(1, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, false);
    goal.setName("Swim");
    assertEquals(goal.getName(), "Swim");
  }

  @Test
  public void testGoalQuestion() throws Exception {
    Reminder reminder = new Reminder(1, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, false);
    assertEquals(goal.getQuestion(), "Did you run today?");
  }

  @Test
  public void testGoalReminderOption() throws Exception {
    Reminder reminder = new Reminder(1, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, false);
    assertEquals(goal.getReminderOption().getTime(), 1);
    assertEquals(goal.getReminderOption().getMeridiem(), "AM");
  }


  @Test
  public void testGoalCompleted() throws Exception {
    Reminder reminder = new Reminder(1, "AM");
    Goal goal = new Goal("Run", "Did you run today?", reminder, false);
    assertEquals(goal.getStatus(), false);
  }
}