package com.telos.christianaushana.telos;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GoalTests {
    Goal goal = new Goal("Run", "Did you run today?", "daily", "9AM");

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGoalName() throws Exception {
        assertEquals(goal.getName(), "Run");
    }

    @Test
    public void testGoalQuestion() throws Exception {
        assertEquals(goal.getQuestion(), "Did you run today?");
    }

    @Test
    public void testGoalReminderOption() throws Exception {
        assertEquals(goal.getReminderOption(), "9AM");
    }

    @Test
    public void testGoalRepeatOption() throws Exception {
        assertEquals(goal.getRepeatOption(), "daily");
    }
}