package com.example.android.manaustouristguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_category, container, false);

        // Create a list of PoIs
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(getString(R.string.restaurant_name_1), getString(R.string.restaurant_description_1), R.drawable.restaurante_amazonico));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.restaurant_name_2), getString(R.string.restaurant_description_2), R.drawable.restaurante_banzeiro));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.restaurant_name_3), getString(R.string.restaurant_description_3), R.drawable.restaurante_bubuia));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.restaurant_name_4), getString(R.string.restaurant_description_4), R.drawable.restaurante_giratorio));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.restaurant_name_5), getString(R.string.restaurant_description_5), R.drawable.restaurante_flutuante_rainha_das_selvas));

        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_restaurant);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PointOfInterest poi = pointsOfInterest.get(position);

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("pointOfInterest", poi);
                startActivity(i);
            }
        });

        return rootView;
    }

}
