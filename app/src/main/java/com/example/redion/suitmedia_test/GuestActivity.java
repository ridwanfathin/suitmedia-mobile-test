package com.example.redion.suitmedia_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.redion.suitmedia_test.R;
import com.example.redion.suitmedia_test.adapter.GuestAdapter;
import com.example.redion.suitmedia_test.adapter.PeopleAdapter;
import com.example.redion.suitmedia_test.api.Request;
import com.example.redion.suitmedia_test.model.GuestModel;
import com.example.redion.suitmedia_test.model.Value;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuestActivity extends AppCompatActivity {
    public static final String URL = "http://dry-sierra-6832.herokuapp.com/api/";
    private List<GuestModel> guestModelList = new ArrayList<>();
    private GuestAdapter guestAdapter;
    @BindView(R.id.recycler)RecyclerView recyclerView;
    @BindView(R.id.progress_bar)ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        ButterKnife.bind(this);
        guestAdapter = new GuestAdapter(this, guestModelList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(guestAdapter);


        loadDataGuest();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataGuest();
    }

    private void loadDataGuest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Request api = retrofit.create(Request.class);
        Call<Value> call = api.viewGuest();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                if (value.equals("1")) {
                    guestModelList = response.body().getResult();
                    guestAdapter = new GuestAdapter(GuestActivity.this, guestModelList);
                    recyclerView.setAdapter(guestAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });

        GuestModel person = new GuestModel();
        person.setId(1);
        person.setName("Andi");
        person.setBirthdate("2014-01-01");
        guestModelList.add(person);

        person = new GuestModel();
        person.setId(2);
        person.setName("Budi");
        person.setBirthdate("2014-02-02");
        guestModelList.add(person);

        person = new GuestModel();
        person.setId(3);
        person.setName("Charlie");
        person.setBirthdate("2014-03-03");
        guestModelList.add(person);

        person = new GuestModel();
        person.setId(4);
        person.setName("Dede");
        person.setBirthdate("2014-06-06");
        guestModelList.add(person);

        person = new GuestModel();
        person.setId(5);
        person.setName("Joko");
        person.setBirthdate("2014-02-12");
        guestModelList.add(person);
        guestAdapter = new GuestAdapter(GuestActivity.this, guestModelList);
        recyclerView.setAdapter(guestAdapter);
    }
}
