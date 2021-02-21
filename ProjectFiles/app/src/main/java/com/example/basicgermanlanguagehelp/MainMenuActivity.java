package com.example.basicgermanlanguagehelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        //region PreCreated Code to launch the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        //endregion

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
