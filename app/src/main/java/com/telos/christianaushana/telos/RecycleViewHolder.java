package com.telos.christianaushana.telos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by christianaushana on 5/18/17.
 */

public class RecycleViewHolder extends RecyclerView.ViewHolder {

  private TextView mTextView;
  public Goal goal;
  CardView cardView;

  public RecycleViewHolder(final View itemView) {
    super(itemView);
    mTextView = (TextView) itemView.findViewById(R.id.textView);
    cardView = (CardView) itemView.findViewById(R.id.cv);

    // opens to detailed view of goal
    itemView.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        Intent viewIntent = new Intent(itemView.getContext(), DetailActivity.class);
        viewIntent.putExtra("DATA_POSITION_INTENT", RecycleViewHolder.this.getAdapterPosition());
        itemView.getContext().startActivity(viewIntent);
        return true;
      }
    });

    // shows popup toast with instructions
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Context context =  itemView.getContext();
        CharSequence text = "Long press to see details.\n         Swipe to delete!";
        int duration = Toast.LENGTH_SHORT;

        Toast.makeText(context, text, duration).show();
      }
    });
  }

  public void bind(final Goal goal) {
    this.goal = goal;
    mTextView.setText(goal.getName());
//            int color = itemView.getContext().getResources().getColor(R.color.colorAccent);
//            itemView.setBackgroundColor(entry.b ? color: 0x00000000);
  }
}
