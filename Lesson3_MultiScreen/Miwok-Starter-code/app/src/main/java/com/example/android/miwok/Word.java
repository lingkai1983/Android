package com.example.android.miwok;

/**
 * Created by lingk on 1/13/2017.
 */

public class Word {
    private String defaultWord;
    private String miwokWord;
    private int imgResourceID;
    private  boolean ownImageID;


    public Word(String defaultWord, String miwokWord) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.ownImageID = false;

    }

    public  Word(String defaultWord, String miwokWord, int imgResourceID){
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.imgResourceID = imgResourceID;
        this.ownImageID = true;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public int getImgResourceID() {return imgResourceID;}

    public  boolean hasImageResourceID() { return  ownImageID; }
}
