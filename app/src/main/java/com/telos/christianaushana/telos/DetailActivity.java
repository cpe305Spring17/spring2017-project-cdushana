package com.telos.christianaushana.telos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by christianaushana on 5/18/17.
 */

public class DetailActivity extends AppCompatActivity {
  int notificationID;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    // retrieves data from MainActivity
    Intent intent = getIntent();
    int position = intent.getIntExtra("DATA_POSITION_INTENT", 1);
    final Goal goal = MainActivity.list.get(position);

    // displays details on DetailsActivity
    TextView tName = (TextView) findViewById(R.id.name);
    tName.setText(goal.getName());

    // displays details on DetailsActivity
    final TextView tQuestion = (TextView) findViewById(R.id.question);
    tQuestion.setText(goal.getQuestion());

    // checkbox confirms that goal has been completed
    CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        goal.setStatus(isChecked);
      }
    });
    checkBox.setChecked(goal.getStatus());

    // show yesterday's data
    if (checkBox.isChecked()) {
      // change color of box?
    }

    // send notification
    Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),
            0, notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
    mBuilder.setSmallIcon(R.drawable.ic_menu_add)
            .setContentTitle("Telos")
            .setContentText(goal.getQuestion())
            .setContentIntent(contentIntent)
            .setWhen(System.currentTimeMillis());

    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(notificationID, mBuilder.build());
  }


}
