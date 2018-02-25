package com.example.redion.suitmedia_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.redion.suitmedia_test.R;
import com.example.redion.suitmedia_test.model.GuestModel;

import java.util.List;


/**
 * Created by redion on 25/02/18.
 */

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {
    private Context context;
    private List<GuestModel> guestModelList;

    public GuestAdapter(Context context, List<GuestModel> guestModelList) {
        this.context = context;
        this.guestModelList = guestModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_guest, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GuestModel mhs = guestModelList.get(position);
//        holder.txtId.setText(mhs.getId().toString());
        holder.txtNama.setText(mhs.getName());
//        holder.txtBirthdate.setText(mhs.getBirthdate());


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
