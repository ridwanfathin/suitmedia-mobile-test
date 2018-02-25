package com.example.redion.suitmedia_test;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare component
    private TextView tVName;
    private TextView btnEvent;
    private TextView btnGuest;
    private String name;

    //declare context
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        startInit();

        // Parsing Parameter
        Intent myIntent = getIntent(); // gets the previously created intent
        name = (myIntent.getStringExtra("name")!=null) ? myIntent.getStringExtra("name") : "Nama";
        tVName.setText(name);
    }

    public void startInit() {
        initToolbar();
        initUI();
        initEvent();
    }

    public void initToolbar() {
        getSupportActionBar().hide();
    }

    public void initUI() {
        tVName=(TextView)findViewById(R.id.tVName);
        btnEvent=(Button)findViewById(R.id.btnEvent);
        btnGuest=(Button)findViewById(R.id.btnGuest);
    }

    public void initEvent() {
        btnGuest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(mContext,GuestActivity.class);;
                intent.putExtra("name",name);
                mContext.startActivity(intent);
            }
        });
        btnEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EventActivity.class);;
                intent.putExtra("name",name);
                mContext.startActivity(intent);
            }
        });
    }

}
