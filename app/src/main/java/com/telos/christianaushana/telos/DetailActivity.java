package com.telos.christianaushana.telos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by christianaushana on 5/18/17.
 */

public class DetailActivity extends AppCompatActivity {
  int notificationID;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    Intent intent = getIntent();
    int position = intent.getIntExtra("DATA_POSITION_INTENT", 1);
    final Goal goal = MainActivity.list.get(position);

    TextView tName = (TextView) findViewById(R.id.name);
    tName.setText(goal.getName());

    final TextView tQuestion = (TextView) findViewById(R.id.question);
    tQuestion.setText(goal.getQuestion());

    TextView tReminder = (TextView) findViewById(R.id.reminder);
    tReminder.setText(goal.getReminderOption().getTime() + goal.getReminderOption().getMeridiem());

//    TextView tRepeat = (TextView) findViewById(R.id.repeat);
//    tRepeat.setText(goal.getRepeatOption());

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
        mBuilder.setSmallIcon(R.drawable.ic_menu_add)
                .setContentTitle("Telos")
                .setContentText(goal.getQuestion())
                .setContentIntent(contentIntent);
//                .setWhen();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
      }
    });
  }
}
