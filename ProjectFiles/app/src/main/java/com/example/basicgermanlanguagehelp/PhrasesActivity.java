package com.example.basicgermanlanguagehelp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
                    Intent familyIntent = new Intent(PhrasesActivity.this, FamilyActivity.class);
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
                    Intent numbersIntent = new Intent(PhrasesActivity.this, NumberActivity.class);
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
                    Intent colorIntent = new Intent(PhrasesActivity.this, ColorActivity.class);
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
                    Intent colorIntent = new Intent(PhrasesActivity.this, PhrasesActivity.class);
                    startActivity(colorIntent);
                }
            });
            //endregion
            //endregion
        }
    }
}
