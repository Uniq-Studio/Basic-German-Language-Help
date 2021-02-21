package com.example.basicgermanlanguagehelp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static org.xmlpull.v1.XmlPullParser.TEXT;

public class PreBigTexActivity extends AppCompatActivity {

    //Creating variables to control the views
    private String usersName;
    private CheckBox checkBox;
    private EditText editText;
    private Button launchButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Launch into the settings for big screen
        setContentView(R.layout.activity_bigtext_pre);

        //Linking the views to a variable
        editText =      findViewById(R.id.editText);
        checkBox =      findViewById(R.id.alone);
        launchButton =  findViewById(R.id.launchButton);

        boolean alone = checkBox.isChecked();

        //Load saved information
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //What information we want to load
        String userNameReload = preferences.getString("usersName", "");
        boolean aloneReload = preferences.getBoolean("alone",false);
        //Where should the info load
        editText.setText(userNameReload);
        checkBox.setChecked(aloneReload);
    }


    public void LaunchBigText(View view) {
        //Saving the name in a public Variable
        usersName = editText.getText().toString();
        boolean isAlone = checkBox.isChecked();

        //Saving the inputted information in Shared Prefaces
        SharedPreferences saver = PreferenceManager.getDefaultSharedPreferences(PreBigTexActivity.this);
        //Edit if the value got changed
        SharedPreferences.Editor editor = saver.edit();

        //Looks at the string to what to save
        editor.putString("usersName", usersName);
        editor.putBoolean("alone", isAlone);
        //Saves it
        editor.apply();

        //Load into BIg Text Mode
        Intent bigTM = new Intent(PreBigTexActivity.this, BigTextActivity.class);
        startActivity(bigTM);
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
        //https://stackoverflow.com/questions/3872063/how-to-launch-an-activity-from-another-application-in-android
    }

    //endregion
}
