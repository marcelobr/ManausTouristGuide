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
public class MostVisitedFragment extends Fragment {


    public MostVisitedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_category, container, false);

        // Create a list of PoIs
        final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_1), getString(R.string.most_visited_description_1), R.drawable.teatro_amazonas));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_2), getString(R.string.most_visited_description_2), R.drawable.encontro_das_aguas_rios_negro_e_solimoes));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_3), getString(R.string.most_visited_description_3), R.drawable.arena_da_amazonia));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_4), getString(R.string.most_visited_description_4), R.drawable.palacio_rio_negro));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_5), getString(R.string.most_visited_description_5), R.drawable.praia_ponta_negra));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_6), getString(R.string.most_visited_description_6), R.drawable.mercado_municipal));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_7), getString(R.string.most_visited_description_7), R.drawable.ponte_rio_negro));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_8), getString(R.string.most_visited_description_8), R.drawable.praia_da_lua));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_9), getString(R.string.most_visited_description_9), R.drawable.bosque_da_ciencia));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_10), getString(R.string.most_visited_description_10), R.drawable.jardim_botanico));
        pointsOfInterest.add(new PointOfInterest(getString(R.string.most_visited_name_11), getString(R.string.most_visited_description_11), R.drawable.parque_do_mindu));

        PointOfInterestAdapter adapter = new PointOfInterestAdapter(getActivity(), pointsOfInterest, R.color.category_most_visited);

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
