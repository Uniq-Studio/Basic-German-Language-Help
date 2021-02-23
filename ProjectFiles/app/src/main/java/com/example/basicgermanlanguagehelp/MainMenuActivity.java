package com.example.basicgermanlanguagehelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        //region Pre-made code
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //endregion

        //region Buttons
        //region Linking Views
        RelativeLayout family = findViewById(R.id.FamilyCard);
        RelativeLayout numbers = findViewById(R.id.NumberCard);
        RelativeLayout colors = findViewById(R.id.ColorsCard);
        RelativeLayout phrases = findViewById(R.id.PhrasesCard);
        //endregion

        //region Launching Family View
        //We are using an onClickListener as its recommenced by Google and will wait till we tap on
        //the view
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When it notices the onclick it will start the Family Activity
                Intent familyIntent = new Intent(MainMenuActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });
        //endregion

        //region Launching Numbers View
        //We are using an onClickListener as its recommenced by Google and will wait till we tap on
        //the view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When it notices the onclick it will start the Family Activity
                Intent numbersIntent = new Intent(MainMenuActivity.this, NumberActivity.class);
                startActivity(numbersIntent);
            }
        });
        //endregion

        //region Launching Colors View
        //We are using an onClickListener as its recommenced by Google and will wait till we tap on
        //the view
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When it notices the onclick it will start the Family Activity
                Intent colorIntent = new Intent(MainMenuActivity.this, ColorActivity.class);
                startActivity(colorIntent);
            }
        });
        //endregion

        //region Launching Phrases View
        //We are using an onClickListener as its recommenced by Google and will wait till we tap on
        //the view
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When it notices the onclick it will start the Family Activity
                Intent colorIntent = new Intent(MainMenuActivity.this, PhrasesActivity.class);
                startActivity(colorIntent);
            }
        });
        //endregion
        //endregion
    }


    //region Menu

    //Creates the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Loads the list
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Find the ID linked to the button in the menu
        int menuItemSelected = item.getItemId();

        //The user clicked on Big Text
        if (menuItemSelected == R.id.BigTextMenu) {
            Intent i = new Intent(MainMenuActivity.this, PreBigTexActivity.class);
            //This runs the command and changes view
            startActivity(i);
            return true;
        }

        //The user clicked on Phone Numbers
        if (menuItemSelected == R.id.NumMenu) {
            //Creating a new intent that that's this current view and change the class
            Intent i = new Intent(MainMenuActivity.this, NumberScreen.class);
            //This runs the command and changes view
            startActivity(i);
            return true;
        }

        //The user clicked on the About App
        if (menuItemSelected == R.id.AboutMenu) {
            //Creating a new intent that that's this current view and change the class
            Intent i = new Intent(MainMenuActivity.this, AboutScreen.class);
            //This runs the command and changes view
            startActivity(i);
            return true;
        }
        //Runs the method
        return super.onOptionsItemSelected(item);
    }
    //endregion
}
