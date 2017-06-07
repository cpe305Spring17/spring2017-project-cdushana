package com.telos.christianaushana.telos.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.telos.christianaushana.telos.R;

/**
 * Created by christianaushana on 5/26/17.
 */

public class SendNotification {

  public class MainActivity extends AppCompatActivity {
    int notificationID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      sendNotification();
    }

    public void sendNotification() {
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
      mBuilder.setSmallIcon(R.drawable.ic_action_back);
      mBuilder.setContentTitle("Notification Alert, Click Me!");
      mBuilder.setContentText("Hi, This is Android Notification Detail!");

      NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      mNotificationManager.notify(notificationID, mBuilder.build());
    }
  }
}
