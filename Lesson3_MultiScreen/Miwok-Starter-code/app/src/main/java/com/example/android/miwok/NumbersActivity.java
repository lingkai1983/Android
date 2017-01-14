package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ArrayList<Word> words = new ArrayList<Word> ();

        words.add(new Word("One","Lutti"));
        words.add(new Word("Two","Otiiko"));
        words.add(new Word("Three","tolookosu"));
        words.add(new Word("Four","Oyylsa"));
        words.add(new Word("Five","Massokka"));
        words.add(new Word("Six","Temmokka"));
        words.add(new Word("Seven","Keneksku"));
        words.add(new Word("Eight","Kawnta"));
        words.add(new Word("Nine","Wo'e"));
        words.add(new Word("Ten","na'aacha"));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

         ListView listView = (ListView) findViewById(R.id.number_list);

         listView.setAdapter(itemsAdapter);

    }
}
