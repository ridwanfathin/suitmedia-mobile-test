package com.example.redion.suitmedia_test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    //declare component
    private EditText eTName;
    private TextView btnNext;

    //declare context
    private Context mContext;

    public static final String MY_PREFS_NAME = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext=this;
        startInit();

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
        eTName=(EditText)findViewById(R.id.eTName);
        btnNext=(Button)findViewById(R.id.btnNext);
    }

    public void initEvent() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!validate_input()){
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("name", eTName.getText().toString());
                    editor.putString("eventName", "Pilih Event");
                    editor.putString("guestName", "Pilih Guest");
                    editor.apply();
                    Intent intent = new Intent(mContext,MainActivity.class);
                    intent.putExtra("from","home");
                    mContext.startActivity(intent);
                }else{
                    Toast.makeText(mContext,"Nama harus diisi",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean validate_input(){
        return (eTName.getText().toString().isEmpty());
    }
}
