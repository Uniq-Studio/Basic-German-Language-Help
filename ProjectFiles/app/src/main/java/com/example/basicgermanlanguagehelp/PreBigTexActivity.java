package com.example.basicgermanlanguagehelp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreBigTexActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Launch into the settings for big screen
        setContentView(R.layout.activity_bigtext_pre);
    }

    public void LaunchBigText(View view) {
    }



    //region Launch Personal Safety
    String personalSafetyGoogle = "com.google.android.apps.safetyhub";
    public void LaunchApp(View view){
        //Tells the intent what it is we want launched
        Intent i = getPackageManager().getLaunchIntentForPackage(personalSafetyGoogle);
        if (i != null) {
            //If it did not fail then app will load
            startActivity(i);
        } else {
            //If the user doesn't own a Pixel or enable the app, Notify the user of this
            Toast.makeText(PreBigTexActivity.this, "Hmm... I cannot launch it. " +
                                                                "\nIs it enabled?" +
                                                                "\nAre you using a Pixel Device?", Toast.LENGTH_LONG).show();
        }

    }
    //endregion


}
