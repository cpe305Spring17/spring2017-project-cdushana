package com.telos.christianaushana.telos;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

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
        questionInput.setHint("Create question (Did you workout today?");
        layout.addView(questionInput);

        // modify later
        final EditText repeatOption = new EditText(context);
        repeatOption.setHint("repeat");
        layout.addView(repeatOption);
//        ArrayList<String> repeatOptionList = new ArrayList<String>();
//        repeatOptionList.add()
        final Spinner repeatOptionSpinner = new Spinner(context);





        // modify later
        final EditText reminderOption = new EditText(context);
        reminderOption.setHint("reminder");
        layout.addView(reminderOption);

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
                        if (repeatOption.getText().toString().length() > 0) {
                            goal.setRepeatOption(repeatOption.getText().toString());
                        }
                        if (reminderOption.getText().toString().length() > 0) {
                            goal.setReminderOption(reminderOption.getText().toString());
                        }
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

//    public ArrayList<String> createRepeatOptions() {
//
//    }
}
