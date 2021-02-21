package com.example.basicgermanlanguagehelp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BigTextActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {


        //region PreCreated Code to launch the view
        super.onCreate(savedInstanceState);
        //Loads into the About Screen
        setContentView(R.layout.activity_bigtext);
        TextView username = findViewById(R.id.NameBox);
        TextView isAlone = findViewById(R.id.aloneText);

        //Load saved information
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //What information we want to load
        String userNameReload = preferences.getString("usersName", "");
        boolean aloneReload = preferences.getBoolean("alone",false);
        //Where should the info load

        username.setText(userNameReload);

        if (!aloneReload){
            isAlone.setText(R.string.Line3False);
        }
        else if (aloneReload){
            isAlone.setText(R.string.Line3True);
        }
    }
}
