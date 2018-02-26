package com.example.redion.suitmedia_test.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.bumptech.glide.Glide;
import com.example.redion.suitmedia_test.MainActivity;
import com.example.redion.suitmedia_test.R;
import com.example.redion.suitmedia_test.model.GuestModel;

import java.util.List;


/**
 * Created by redion on 25/02/18.
 */

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.MyViewHolder> {

    private Context mContext;
    private List<GuestModel> guestModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public CardView card;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tVGuestName);
            image = (ImageView) view.findViewById(R.id.imgGuest);
            card = (CardView) view.findViewById(R.id.card_view);
        }
    }


    public GuestAdapter(Context context, List<GuestModel> guestModelList) {
        this.mContext = context;
        this.guestModelList = guestModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_guest, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final GuestModel guest =  guestModelList.get(position);
        holder.name.setText(guest.getName());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,MainActivity.class);
                intent.putExtra("from","guest");
                intent.putExtra("guestName",guest.getName());
                intent.putExtra("birthdate",guest.getBirthdate());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return guestModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

//        @BindView(R.id.id)TextView txtId;
        @BindView(R.id.tVGuestName)TextView txtNama;
//        @BindView(R.id.birthdate)TextView txtBirthdate;
        @BindView(R.id.imgGuest)ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }
    }
}
