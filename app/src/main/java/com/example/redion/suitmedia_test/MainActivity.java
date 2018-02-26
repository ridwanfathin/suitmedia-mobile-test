package com.example.redion.suitmedia_test;

import android.app.Fragment;
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

public class MainActivity extends AppCompatActivity {

    //declare component
    private TextView tVName;
    private TextView btnEvent;
    private TextView btnGuest;
    private String name;
    private String eventName;
    private String guestName;
    private String prev;

    //declare context
    private Context mContext;

    public static final String MY_PREFS_NAME = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        startInit();
        setPreferences();

        //get stored value
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        name = prefs.getString("name", "Nama");
        eventName = prefs.getString("eventName", "Pilih Event");
        guestName = prefs.getString("guestName", "Pilih Guest");

        tVName.setText(name);
        btnEvent.setText(eventName);
        btnGuest.setText(guestName);

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

    public void setPreferences() {
        // Parsing Parameter
        Intent myIntent = getIntent(); // gets the previously created intent

        //get the previous activity - set current changed value
        prev = myIntent.getStringExtra("from");
        if(prev.equalsIgnoreCase("home")){
            SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
            name = prefs.getString("name", "Nama");
            if(isPalindrome(name)){
                Toast.makeText(mContext,"isPalindrome",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(mContext,"not palindrome",Toast.LENGTH_LONG).show();
            }
        }else if(prev.equalsIgnoreCase("event")){
            eventName = (myIntent.getStringExtra("eventName")!=null) ? myIntent.getStringExtra("eventName") : "Pilih Event";
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString("eventName", eventName);
            editor.apply();
        }else{
            guestName = (myIntent.getStringExtra("guestName")!=null) ? myIntent.getStringExtra("guestName") : "Pilih Guest";
            if(myIntent.getStringExtra("guestName")!=null){
                String date = myIntent.getStringExtra("birthdate");
                int dateInt = (int) date.charAt(8)*10 + (int) date.charAt(9); //YYYY-MM-DD
                if((dateInt%2==0) && (dateInt%3 == 0)){
                    Toast.makeText(mContext,"iOS",Toast.LENGTH_LONG).show();
                }else if(dateInt%2==0){
                    Toast.makeText(mContext,"blackberry",Toast.LENGTH_LONG).show();
                }else if(dateInt%3 == 0){
                    Toast.makeText(mContext,"android",Toast.LENGTH_LONG).show();
                }
            }

            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString("guestName", guestName);
            editor.apply();
        }
    }

    public boolean isPalindrome(String s){
        boolean flag  = true;

        s = s.replaceAll(" ","");

        int i=0, j= s.length()-1;

        while(flag && i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                flag = false;
            }
            i++;
            j--;
        }
        return flag;
    }

}
