package com.example.basicgermanlanguagehelp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    //Creating variable to control audio and focus of the audio
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    //region Media Player code
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    //If the focus is lost, pause it and restart from beginning
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //Resumes Playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                        //stops playing
                    }
                }
            };

    //The listener get triggered when the audio stops playing
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //abandon audio focus when playback finishes
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        //When the user leaves the app then all of the resources stop
        releaseMediaPlayer();
    }
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //region Activate Buttons in Landscape
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
        //endregion

        //create and setup the audio manager to get audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //region Array of Words
        final ArrayList<Word> Phrases = new ArrayList<Word>();
        Phrases.add(new Word("Where are you going?", "Wohin gehst du?",
                R.drawable.deu, R.raw.phrases_where_are_you_going));
        Phrases.add(new Word("What is your name?", "Wie ist dein Name?",
                R.drawable.deu, R.raw.phrases_what_is_your_name));
        Phrases.add(new Word("My name is...", "Ich heisse",
                R.drawable.deu, R.raw.phrases_my_name_is));
        Phrases.add(new Word("How are you feeling?", "Wie geht es dir?",
                R.drawable.deu, R.raw.phrases_how_are_you_feeling));
        Phrases.add(new Word("I’m feeling good.", "Ich fühle mich gut",
                R.drawable.deu, R.raw.phrases_im_feeling_good));
        Phrases.add(new Word("Are you coming?", "Kommst du?",
                R.drawable.deu, R.raw.phrases_are_you_coming));
        Phrases.add(new Word("Yes, I’m coming.", "Ja, ich komme",
                R.drawable.deu, R.raw.phrases_yes_im_coming));
        Phrases.add(new Word("I’m coming.", "Ich komme",
                R.drawable.deu, R.raw.phrases_im_coming));
        Phrases.add(new Word("Let’s go.", "Lass uns gehen",
                R.drawable.deu, R.raw.phrases_lets_go));
        Phrases.add(new Word("Come here.", "Komm her",
                R.drawable.deu, R.raw.phrases_come_here));


        //Now lets link it to our word adapter
        WordAdapter Adapter =
                new WordAdapter(this, Phrases, R.color.phrasesActivity);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(Adapter);
        //endregion

        //region Wait till someone taps a view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = Phrases.get(position);

                //Releases the media player if it currently exist because another sound wants
                //to play instead
                releaseMediaPlayer();

                //request audio focus
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //Stream the audio
                        AudioManager.STREAM_MUSIC,
                        //Make it the focus so the audio can play
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                //If allowed to take focus
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getImageResourceId());
                    //Starts Playback.


                    //finds which audio to play from the array
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioPlayerID());
                    mMediaPlayer.start();

                    //Setup a listener on the media player to see if it has stopped
                    //and free up the memory by removing it
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        //endregion
    }
}
/*
Audio Code was created by Google Udacity Miwok App
 */
