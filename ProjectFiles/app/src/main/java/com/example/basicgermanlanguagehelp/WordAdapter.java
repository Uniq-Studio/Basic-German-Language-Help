package com.example.basicgermanlanguagehelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    //ID for the background color for the section
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Gets the Number object located at this position in the list
        Word currentWord = getItem(position);

        //Find the TextView in the XML layout with the ID
        TextView GermanTextView = listItemView.findViewById(R.id.German_Text);
        //Get The German translation from the object and set the text
        GermanTextView.setText(currentWord.getGermanWord());

        //Find the TextView in the XML layout with the ID
        TextView defaultTextView = listItemView.findViewById(R.id.English_Text);
        //Get The English translation from the object and set the text
        defaultTextView.setText(currentWord.getEnglishWord());

        //Find the imageView
        ImageView iconView = listItemView.findViewById(R.id.image);
        //Checks is the currentWord has an image then run the code, if not skip it
        if (currentWord.hasImage()) {
            //Get the Image ID and set the image as the Icon
            iconView.setImageResource(currentWord.getImageResourceId());
        } else {
            //Hide the image view from displaying if there isn't one
            iconView.setVisibility(View.GONE);
        }

        //set the theme color
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Locate the color to the ID that's linked
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color
        textContainer.setBackgroundColor((color));

        //Returns the whole list with item Layout
        return listItemView;
}}
