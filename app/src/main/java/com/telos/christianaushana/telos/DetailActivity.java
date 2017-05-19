package com.telos.christianaushana.telos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by christianaushana on 5/18/17.
 */

public class DetailActivity extends AppCompatActivity {
  private int position;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    Intent intent = getIntent();
    position = intent.getIntExtra("DATA_POSITION_INTENT", 1);
    final Goal goal = MainActivity.list.get(position);

    TextView tName = (TextView) findViewById(R.id.name);
    tName.setText(goal.getName());
    TextView tQuestion = (TextView) findViewById(R.id.question);
    tQuestion.setText(goal.getQuestion());
    TextView tReminder = (TextView) findViewById(R.id.reminder);
    tReminder.setText(goal.getReminderOption());
    TextView tRepeat = (TextView) findViewById(R.id.repeat);
    tRepeat.setText(goal.getRepeatOption());
  }
}
