package com.telos.christianaushana.telos;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public AlertDialog diaBox;
    static ArrayList<Goal> list;
    static RecycleAdapter adapter;
    static RecyclerView rv;
//    public AddGoal addGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        assert rv != null;

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        list = new ArrayList<Goal>();
//        if (list == null) {
//            try {
//                DataManager.readDataFromFile(this);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        list = DataManager.list;




        adapter = new RecycleAdapter(list);
        rv.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                RecycleViewHolder rvh = (RecycleViewHolder) viewHolder;
                if (direction == ItemTouchHelper.RIGHT) {
                    int index = viewHolder.getAdapterPosition();
                    AlertDialog diaBox = AskOption(adapter, index);
                    diaBox.show();
                }
//                else if (direction == ItemTouchHelper.LEFT) {
////                    Entry entry = rvh.mEntry; // uncomment to check when swiped left
////                    entry.b = !entry.b;
//                    adapter.notifyItemChanged(viewHolder.getAdapterPosition());
//                }

            }
        };

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings_menu:
                Log.d(TAG, "Settings");
                startActivity(new Intent(this, Settings.class));
                return true;
            case R.id.add_action:
                // dialog box will display and provide areas to input data
//                addGoal = new AddGoal();
                diaBox = AddGoal.addGoal(MainActivity.this);
                diaBox.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private AlertDialog AskOption(final RecycleAdapter adapter, final int position)
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Remove Entry")
                .setMessage("Do you want to remove this item?")

                .setPositiveButton("Remove", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (list.get(position).name != null) {
                            File file = new File(list.get(position).name);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        list.remove(position);
                        adapter.notifyDataSetChanged();
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

  public void sendNotification(View view) {
    NotificationCompat.Builder mBuilder =
            (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_action_back)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!");

    // Gets an instance of the NotificationManager service//
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    //When you issue multiple notifications about the same type of event, it’s best practice for your app to try to update an existing
    // notification with this new information, rather than immediately creating a new notification.
    // If you want to update this notification at a later date, you need to assign it an ID. You can
    // then use this ID whenever you issue a subsequent notification. If the previous notification is still visible,
    // the system will update this existing notification, rather than create a new one. In this example, the notification’s ID is 001//
//    NotificationManager.notify().mNotificationManager.notify(001, mBuilder.build());

  }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        DataManager.writeDataToFile(this);
    }
}

