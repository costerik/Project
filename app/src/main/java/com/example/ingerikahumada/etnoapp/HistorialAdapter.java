package com.example.ingerikahumada.etnoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ing. Erik Ahumada on 16/11/2015.
 */
public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.ViewHolder> {

    ArrayList<String> mDataset;

    public HistorialAdapter(ArrayList<String> dataset){
        this.mDataset=dataset;
    }

    @Override
    public HistorialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_view_historial, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTextView(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;

        public ViewHolder(View v){
            super(v);
            mTextView=(TextView)v.findViewById(R.id.text_view_historial);
        }

        public void bindTextView(String data){
            this.mTextView.setText(data);
        }

    }
}
