package com.example.basicgermanlanguagehelp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FamilyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //If the device is in landscape, Run the buttons command to change to different sections
        //but not when in portrait as there are no views named that in portrait and could
        //cause a crash
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
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
                    Intent familyIntent = new Intent(FamilyActivity.this, FamilyActivity.class);
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
                    Intent numbersIntent = new Intent(FamilyActivity.this, NumberActivity.class);
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
                    Intent colorIntent = new Intent(FamilyActivity.this, ColorActivity.class);
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
                    Intent colorIntent = new Intent(FamilyActivity.this, PhrasesActivity.class);
                    startActivity(colorIntent);
                }
            });
            //endregion
            //endregion
        }
    }
}
