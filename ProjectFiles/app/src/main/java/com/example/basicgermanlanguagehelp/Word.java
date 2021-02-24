package com.example.basicgermanlanguagehelp;

public class Word {
    //Incase the section does not have an image
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Get the German Word
    private String mGermanWord;

    //Get the english word
    private String mEnglishWord;

    //Media Player
    private int mAudioPlayer;
    //We are using ints because we are selecting the item from an array

    public Word(String englishWord, String germanWord, int imageResourceId, int audioPlayer) {
        mEnglishWord = englishWord;
        mGermanWord = germanWord;
        mImageResourceId = imageResourceId;
        mAudioPlayer = audioPlayer;
    }

    //Get the English translation Method
    public String getEnglishWord() {
        return mEnglishWord;
    }

    //Get the German translation Method
    public String getGermanWord() {
        return mGermanWord;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioPlayerID() {
        return mAudioPlayer;
    }

    //To see if a category has an image or not
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
