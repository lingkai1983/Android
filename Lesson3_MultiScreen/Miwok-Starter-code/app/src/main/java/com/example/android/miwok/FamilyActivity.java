package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> families = new ArrayList<Word> ();

        families.add(new Word("Father","әpә"));
        families.add(new Word("Mother","әṭa"));
        families.add(new Word("Son","angsi"));
        families.add(new Word("Daughter","tune"));
        families.add(new Word("Old Brother","taachi"));
        families.add(new Word("Younger Brother","chalitti"));
        families.add(new Word("Older Sister","teṭe"));
        families.add(new Word("Younger Sister","kolliti"));
        families.add(new Word("Grandmother","ama"));
        families.add(new Word("Grandfather","paapa"));

        WordAdapter itemAdapter = new WordAdapter(this, families);
        ListView    familiesView = (ListView) findViewById(R.id.family_list);
        familiesView.setAdapter(itemAdapter);
    }
}
