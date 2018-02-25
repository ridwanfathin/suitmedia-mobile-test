package com.example.redion.suitmedia_test.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.redion.suitmedia_test.MainActivity;
import com.example.redion.suitmedia_test.R;
import com.example.redion.suitmedia_test.model.people.DataPeople;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by redion on 25/02/18.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder>{
    private List<DataPeople> peopleList;
    private int lastPosition=-1;
    private View mView;

    public PeopleAdapter(){
//        final Call<ResponsePeople> People= client.getApi().dataPeople();
//        People.enqueue(new Callback<ResponsePeople>() {
//            @Override
//            public void onResponse(Call<ResponsePeople> call, Response<ResponsePeople> response) {
//                if (response.isSuccessful()) {
//                    dataPeople=response.body();
//                    peopleList.clear();
//                    peopleList.addAll(dataPeople.getData());
//                    mAdapter.notifyDataSetChanged();
//                }else{
//                    Toast.makeText(mContext,"Error get data",Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponsePeople> call, Throwable t) {
//                Toast.makeText(mContext,"Error API access",Toast.LENGTH_LONG).show();
//            }
//        });
        DataPeople person = new DataPeople();
        person.setId(1);
        person.setName("Andi");
        person.setBirthdate("2014-01-01");
        peopleList.add(person);

        person = new DataPeople();
        person.setId(2);
        person.setName("Budi");
        person.setBirthdate("2014-02-02");
        peopleList.add(person);

        person = new DataPeople();
        person.setId(3);
        person.setName("Charlie");
        person.setBirthdate("2014-03-03");
        peopleList.add(person);

        person = new DataPeople();
        person.setId(4);
        person.setName("Dede");
        person.setBirthdate("2014-06-06");
        peopleList.add(person);

        person = new DataPeople();
        person.setId(5);
        person.setName("Joko");
        person.setBirthdate("2014-02-12");
        peopleList.add(person);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private View view;

        public MyViewHolder(View view) {
            super(view);
            mView=view;
            name = (TextView) view.findViewById(R.id.tVGuestName);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Gson gson = new Gson();
                    String guest = gson.toJson(peopleList.get(getAdapterPosition()));
                    Intent i=new Intent(view.getContext(),MainActivity.class);
                    i.putExtra("guest", guest);
                    view.getContext().startActivity(i);
                }
            });
            this.view=view;
        }

        public void bindItem(DataPeople people) {
            name.setText(people.getName().toString());
        }

    }


    public PeopleAdapter(List<DataPeople> peopleList) {
        this.peopleList = peopleList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_guest,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeopleAdapter.MyViewHolder holder, int position) {
        holder.bindItem(peopleList.get(position));
//        setAnimation(mView, position);
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

//    private void setAnimation(View viewToAnimate,int position) {
//        if (position > lastPosition) {
//            lastPosition = position;
//            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slide_left_to_right);
//            viewToAnimate.startAnimation(animation);
//        }
//    }
}

