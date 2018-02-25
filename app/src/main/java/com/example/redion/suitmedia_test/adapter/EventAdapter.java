package com.example.redion.suitmedia_test.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.redion.suitmedia_test.MainActivity;
import com.example.redion.suitmedia_test.R;
import com.example.redion.suitmedia_test.model.EventModel;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by redion on 25/02/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context mContext;
    private List<EventModel> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama;
        public ImageView image;
        public TextView tanggal;
        public CardView card;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
            tanggal = (TextView)view.findViewById(R.id.tanggal);
            card = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public EventAdapter(Context mContext, List<EventModel> eventList) {
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_event, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        EventModel event = eventList.get(position);
        holder.nama.setText(event.getNama());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Glide.with(mContext).load(event.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
