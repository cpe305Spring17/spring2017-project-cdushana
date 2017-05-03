package com.telos.christianaushana.telos;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by christianaushana on 5/2/17.
 */

public class AddGoal extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static AlertDialog addGoal(final Activity context/*, final OptionListAdapter adapter*/) {
        final EditText input = new EditText(context);
        input.setHint("Create goal");

        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(context)
                //set message, title, and icon
                .setTitle("Create Goal")
                .setView(input)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (input.getText().toString().length() > 0) {
//                            Option option = new Option(0, 0, 0, 1, input.getText().toString(), "icon");
//                            WeekView.optionList.add(option);
//                            WeekView.optionListAdapter.notifyDataSetChanged();
//                            WeekView.db.addOption(option);
                        }
                        //your deleting code
                        dialog.dismiss();
                    }

                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }
}
