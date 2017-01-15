package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lingk on 1/13/2017.
 */


/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        // Check if an existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
           }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView mikwok = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        mikwok.setText(currentWord.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultWord.setText(currentWord.getDefaultWord());

        if (currentWord.hasImageResourceID()) { // If ImageView has been called by constructor
            // Find the ImageView in the list_item.xml layout with the ID image.
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_picture_view);
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImgResourceID());

            // make sure image is visible again
            imageView.setVisibility(View.VISIBLE);

        }else {
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_picture_view);

            // hide the image
            imageView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
