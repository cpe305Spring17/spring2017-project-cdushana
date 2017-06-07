package com.telos.christianaushana.telos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public AlertDialog diaBox;
    public static ArrayList<Goal> list;
    public static RecycleAdapter adapter;
    public static RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);

        assert rv != null;

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if (list == null) {
            try {
                DataManager.readDataFromFile(this);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        list = DataManager.list;

        adapter = new RecycleAdapter(list);
        rv.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                RecycleViewHolder rvh = (RecycleViewHolder) viewHolder;
                if (direction == ItemTouchHelper.RIGHT) {
                    int index = viewHolder.getAdapterPosition();
                    AlertDialog diaBox = askOption(adapter, index);
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

    private AlertDialog askOption(final RecycleAdapter adapter, final int position)
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

    @Override
    protected void onPause() {
        super.onPause();
        DataManager.writeDataToFile(this);
    }
}

