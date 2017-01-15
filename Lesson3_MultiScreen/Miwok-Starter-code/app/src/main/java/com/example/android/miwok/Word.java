package com.example.android.miwok;

/**
 * Created by lingk on 1/13/2017.
 */

public class Word {
    private String defaultWord;
    private String miwokWord;
    private int imgResourceID;


    public Word(String defaultWord, String miwokWord) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;

    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public int getImgResourceID() {return imgResourceID;}
}
