package com.example.redion.suitmedia_test.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by redion on 25/02/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private Context mContext;
    private List<EventModel> eventList;

    public static final String MY_PREFS_NAME = "MyPrefs" ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public TextView date;
        public CardView card;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tVName);
            image = (ImageView) view.findViewById(R.id.imgEvent);
            date = (TextView)view.findViewById(R.id.tVDate);
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
        final EventModel event = eventList.get(position);
        holder.name.setText(event.getNama());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,MainActivity.class);
                intent.putExtra("from","event");
                intent.putExtra("eventName",event.getNama());
                mContext.startActivity(intent);
            }
        });
        Glide.with(mContext).load(event.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
