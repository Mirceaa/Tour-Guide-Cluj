package com.mirceamoldovan.tourguidecluj;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LandmarksAdapter extends ArrayAdapter<Landmarks>{

    private int mColorResourceId;

    public LandmarksAdapter(Context context, ArrayList<Landmarks> landmarks, int colorResourceId) {
        super(context, 0, landmarks);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.lists, parent, false);
        }

        Landmarks currentLandmark = getItem(position);

        TextView landmarksTextView = (TextView) listItemView.findViewById(R.id.landmarks_text_view);
        landmarksTextView.setText(currentLandmark.getLandmarkName());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentLandmark.getAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this landmark or not
        if (currentLandmark.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentLandmark.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list landmark
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
