package com.example.android.manaustouristguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
* {@link PointOfInterestAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link PointOfInterest} objects.
* */

public class PointOfInterestAdapter extends ArrayAdapter<PointOfInterest> {

    /** Resource ID for the background color for this list of PointOfInterest */
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param pois A List of PointOfInterest objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of PoIs
     */
    public PointOfInterestAdapter(@NonNull Context context, ArrayList<PointOfInterest> pois, int colorResourceId) {
        super(context, 0, pois);
        this.mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_category_item, parent, false);
        }

        // Get the {@link PointOfInterest} object located at this position in the list
        PointOfInterest currentPointOfInterest = getItem(position);

        TextView nameItemTextView = (TextView) listItemView.findViewById(R.id.poi_text_view);
        nameItemTextView.setText(currentPointOfInterest.getmNameOfPoI());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        Glide.with(getContext())
                .load(currentPointOfInterest.getmImageResourceId())
                .into(iconView);

        iconView.setVisibility(View.VISIBLE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
