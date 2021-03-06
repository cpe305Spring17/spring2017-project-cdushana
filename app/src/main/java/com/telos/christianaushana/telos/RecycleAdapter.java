package com.telos.christianaushana.telos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by christianaushana on 5/18/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

  private ArrayList<Goal> list;

  public RecycleAdapter(ArrayList<Goal> list) {
    this.list = list;
  }

  @Override
  public int getItemViewType(int position) {
    return R.layout.list_entry;
  }

  @Override
  public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new RecycleViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
  }

  @Override
  public void onBindViewHolder(RecycleViewHolder holder, int position) {
    holder.bind(list.get(position));
  }

  @Override
  public int getItemCount() {
    if (list != null) {
      return list.size();
    }
    else
      return 0;
  }
}
