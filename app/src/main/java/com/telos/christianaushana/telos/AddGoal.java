package com.telos.christianaushana.telos;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by christianaushana on 5/2/17.
 */

public class AddGoal extends AppCompatActivity {
  private static Integer timeSelection;
  private static String meridiemSelection;
  ArrayList<String> repeatOptionList;
  ArrayList<String> reminderOptionList;
  private static final String TAG = "AddGoal";

    public static AlertDialog addGoal(final Activity context) {
      LinearLayout layout = new LinearLayout(context);
      layout.setOrientation(LinearLayout.VERTICAL);

      final EditText nameInput = new EditText(context);
      nameInput.setHint("Create goal");
      layout.addView(nameInput);

      final EditText questionInput = new EditText(context);
      questionInput.setHint("Create question (Did you workout today?)");
      layout.addView(questionInput);

      TextView reminderQuestion = new TextView(context);
      reminderQuestion.setText("What time do you want to be reminded?");
      layout.addView(reminderQuestion);

      ArrayList<Integer> timeOptionList = new ArrayList<>();
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

      final Spinner timeOptionSpinner = new Spinner(context);
      ArrayAdapter<Integer> timeOptionAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, timeOptionList);
      timeOptionSpinner.setAdapter(timeOptionAdapter);
      layout.addView(timeOptionSpinner);

      timeOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          timeSelection = (Integer) parent.getItemAtPosition(position);
          Log.d(TAG, "onItemSelected: " + timeSelection);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
          timeSelection = (Integer) parent.getItemAtPosition(0);
        }
      });

      ArrayList<String> meridiemOptionList = new ArrayList<>();
      meridiemOptionList.add("PM");
      meridiemOptionList.add("AM");

      final Spinner meridiemOptionSpinner = new Spinner(context);
      ArrayAdapter<String> meridiemOptionAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, meridiemOptionList);
      meridiemOptionSpinner.setAdapter(meridiemOptionAdapter);
      layout.addView(meridiemOptionSpinner);

      meridiemOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          meridiemSelection = (String) parent.getItemAtPosition(position);
          Log.d(TAG, "onItemSelected: " + meridiemSelection);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
          meridiemSelection = (String) parent.getItemAtPosition(0);
        }
      });


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

                        goal.setReminderOption(new Reminder(timeSelection, meridiemSelection));

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
