package com.telos.christianaushana.telos;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void createGoal() throws Exception {
        Goal goal = new Goal();
        goal.setName("Run");
        goal.setQuestion("Did you run today?");
        goal.setReminderOption("9AM");
        goal.setRepeatOption("daily");

        assertEquals(goal.getName(), "Run");
        assertEquals(goal.getQuestion(), "Did you run today?");
        assertEquals(goal.getReminderOption(), "9AM");
        assertEquals(goal.getRepeatOption(), "daily");
    }
}