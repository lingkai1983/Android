package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> colors = new ArrayList<Word>();

        colors.add(new Word("red","wetetti"));
        colors.add(new Word("green","chokokki"));
        colors.add(new Word("brown","takaakki"));
        colors.add(new Word("gray","topoppi"));
        colors.add(new Word("black","kululli"));
        colors.add(new Word("white","kelelli"));
        colors.add(new Word("dusty yellow","topiisa"));
        colors.add(new Word("mustard yellow","chiwita"));

        WordAdapter listAdapter = new WordAdapter(this, colors);
        ListView colorList = (ListView) findViewById(R.id.color_list);
        colorList.setAdapter(listAdapter);

    }
}
