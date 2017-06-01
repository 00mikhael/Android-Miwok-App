package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gravity on 5/29/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourseId;

    public WordAdapter(Activity context, ArrayList<Word> numbers, int colorResourseId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, numbers);
        mColorResourseId = colorResourseId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitems, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_word);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        englishTextView.setText(currentWord.getEnglishWord());




            // Find the ImageView in thr listitem.xml layout with the ID
            ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // set the image of the currentWord
            wordImageView.setImageResource(currentWord.getImageresourceId());
            wordImageView.setVisibility(View.VISIBLE);
        }else {
            wordImageView.setVisibility(View.GONE);
        }

        View categoryLayout = listItemView.findViewById(R.id.category_layout);
        int color = ContextCompat.getColor(getContext(), mColorResourseId);
        categoryLayout.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
