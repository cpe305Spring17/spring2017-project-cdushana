package com.telos.christianaushana.telos;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by christianaushana on 5/2/17.
 */

public class AddGoal extends AppCompatActivity {
    ArrayList<String> repeatOptionList;
    ArrayList<String> reminderOptionList;


    public static AlertDialog addGoal(final Activity context/*, final OptionListAdapter adapter*/) {
      LinearLayout layout = new LinearLayout(context);
      layout.setOrientation(LinearLayout.VERTICAL);

      final EditText nameInput = new EditText(context);
      nameInput.setHint("Create goal");
      layout.addView(nameInput);

      final EditText questionInput = new EditText(context);
      questionInput.setHint("Create question (Did you workout today?)");
      layout.addView(questionInput);

        // modify later
//        final EditText repeatOption = new EditText(context);
//        repeatOption.setHint("repeat");
//        layout.addView(repeatOption);
//        ArrayList<String> repeatOptionList = new ArrayList<String>();
//        repeatOptionList.add()

//      ArrayList<String> repeatOptionList = new ArrayList<String>();
//      repeatOptionList.add("daily");
//      repeatOptionList.add("weekly");
//
//      ArrayList<String> repeatOptionDayList = new ArrayList<String>();
//      repeatOptionDayList.add("monday");
//      repeatOptionDayList.add("tuesday");
//      repeatOptionDayList.add("wednesday");
//      repeatOptionDayList.add("thursday");
//      repeatOptionDayList.add("friday");
//      repeatOptionDayList.add("saturday");
//      repeatOptionDayList.add("sunday");
//
//      final Spinner repeatOptionSpinner = new Spinner(context);
//      ArrayAdapter<String> repeatOptionAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, repeatOptionList);
//      repeatOptionSpinner.setAdapter(repeatOptionAdapter);
//      layout.addView(repeatOptionSpinner);
//
//      final Spinner repeatOptionDaySpinner = new Spinner(context);
//      ArrayAdapter<String> repeatOptionDayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, repeatOptionDayList);
//      repeatOptionDaySpinner.setAdapter(repeatOptionDayAdapter);
//      layout.addView(repeatOptionDaySpinner);

      TextView reminderQuestion = new TextView(context);
      reminderQuestion.setText("What time do you want to be reminded?");
      layout.addView(reminderQuestion);

      ArrayList<Integer> timeOptionList = new ArrayList<Integer>();
      timeOptionList.add(1);
      timeOptionList.add(2);
      timeOptionList.add(3);
      timeOptionList.add(4);
      timeOptionList.add(5);
      timeOptionList.add(6);
      timeOptionList.add(7);
      timeOptionList.add(8);
      timeOptionList.add(9);
      timeOptionList.add(10);
      timeOptionList.add(11);
      timeOptionList.add(12);

      ArrayList<String> meridiemOptionList = new ArrayList<String>();
      meridiemOptionList.add("AM");
      meridiemOptionList.add("PM");

      final Spinner timeOptionSpinner = new Spinner(context);
      ArrayAdapter<Integer> timeOptionAdapter = new ArrayAdapter<Integer>(context, android.R.layout.simple_spinner_item, timeOptionList);
      timeOptionSpinner.setAdapter(timeOptionAdapter);
      layout.addView(timeOptionSpinner);

      final Spinner meridiemOptionSpinner = new Spinner(context);
      ArrayAdapter<String> meridiemOptionAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, meridiemOptionList);
      meridiemOptionSpinner.setAdapter(meridiemOptionAdapter);
      layout.addView(meridiemOptionSpinner);

        // modify later
//        final EditText reminderOption = new EditText(context);
//        reminderOption.setHint("reminder");
//        layout.addView(reminderOption);

        AlertDialog alertDialog = new AlertDialog.Builder(context)
                //set message, title, and icon
                .setTitle("Create Goal")
                .setView(layout)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Goal goal = new Goal();
                        if (nameInput.getText().toString().length() > 0) {
                            goal.setName(nameInput.getText().toString());
                        }
                        if (questionInput.getText().toString().length() > 0) {
                            goal.setQuestion(questionInput.getText().toString());
                        }
//                        if (repeatOption.getText().toString().length() > 0) {
//                            goal.setRepeatOption(repeatOption.getText().toString());
//                        }
//                        if (reminderOption.getText().toString().length() > 0) {
//                            goal.setReminderOption(reminderOption.getText().toString());
//                        }
                        //your deleting code
                        dialog.dismiss();

                        MainActivity.list.add(goal);
                        MainActivity.adapter.notifyDataSetChanged();
                    }

                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return alertDialog;
    }
}
