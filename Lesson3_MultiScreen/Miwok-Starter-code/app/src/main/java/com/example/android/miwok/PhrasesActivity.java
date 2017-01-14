package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        ArrayList<Word> phrases = new ArrayList<Word> ();

        phrases.add(new Word("Where are you going?","minto wuksus"));
        phrases.add(new Word("What is your name?","tinna oyaase'na"));
        phrases.add(new Word("My name is...","oyaaset..."));
        phrases.add(new Word("How are you feeling?","michaksas?"));
        phrases.add(new Word("I'm feeling good.","kuchi achit"));
        phrases.add(new Word("Are you coming?","aanas'aa?"));
        phrases.add(new Word("Yes, I'm coming","haa'aanam"));
        phrases.add(new Word("I'm coming","aanam"));
        phrases.add(new Word("Let's go","yoowutis"));
        phrases.add(new Word("Come here","aani'nem"));

        WordAdapter itemAdapter = new WordAdapter(this, phrases);
        ListView    phraseView = (ListView) findViewById(R.id.phrase_list);
        phraseView.setAdapter(itemAdapter);
    }
}
