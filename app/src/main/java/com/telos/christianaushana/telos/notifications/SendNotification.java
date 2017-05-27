package com.telos.christianaushana.telos.notifications;

/**
 * Created by christianaushana on 5/26/17.
 */

public class SendNotification {

  public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {

//Get an instance of NotificationManager//

      NotificationCompat.Builder mBuilder =
              new NotificationCompat.Builder(this)
                      .setSmallIcon(R.drawable.notification_icon)
                      .setContentTitle("My notification")
                      .setContentText("Hello World!");


// Gets an instance of the NotificationManager service//

      NotificationManager mNotificationManager =

              (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//When you issue multiple notifications about the same type of event, it’s best practice for your app to try to update an existing notification with this new information, rather than immediately creating a new notification. If you want to update this notification at a later date, you need to assign it an ID. You can then use this ID whenever you issue a subsequent notification. If the previous notification is still visible, the system will update this existing notification, rather than create a new one. In this example, the notification’s ID is 001//

      NotificationManager.notify().

              mNotificationManager.notify(001, mBuilder.build());
    }
  }
}
