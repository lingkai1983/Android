package com.example.android.miwok;

import java.util.ArrayList;

/**
 * Created by lingk on 1/13/2017.
 */

public class Word {
   private String defaultWord;
   private String miwokWord;

    public Word(String defaultWord, String miwokWord){
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;

    }

    public String getDefaultWord(){
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }
}
