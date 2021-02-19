package com.example.basicgermanlanguagehelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    //region Variables
    //Creating a Media Player
    MediaPlayer startUpTone;
    //Creating a variable to hold time in milliseconds
    int timeOut = 750;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //region PreCreated Code to launch the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);
        //endregion

        //region Splash Screen Tone
        //We will Create a media player and tell it what file to play
        startUpTone = MediaPlayer.create(SplashScreen.this,R.raw.splash_screen_tone);
        //Now it will play the tone
        startUpTone.start();
        //endregion

        //region Change Splash Screen With Intent
        new Handler().postDelayed(() -> {
            //Creating a new intent that that's this current view and change the class
            Intent i = new Intent(SplashScreen.this, MainMenuActivity.class);
            //This runs the command and changes view
            startActivity(i);
            finish();
            //This is how long it stays on for
        },timeOut);
        //endregion

    }

    //We will be releasing the Media player to free up resources
    protected  void onPause(){
        super.onPause();
        startUpTone.release();
        finish();
    }


}