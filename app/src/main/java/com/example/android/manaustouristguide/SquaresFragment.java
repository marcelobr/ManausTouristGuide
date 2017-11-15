package com.example.android.manaustouristguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SquaresFragment extends Fragment {


    public SquaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_category, container, false);

        // Create a list of PoIs
        final ArrayList<PoI> pois = new ArrayList<PoI>();
        pois.add(new PoI(getString(R.string.square_name_1), getString(R.string.square_description_1), R.drawable.largo_sao_sebastiao));
        pois.add(new PoI(getString(R.string.square_name_2), getString(R.string.square_description_2), R.drawable.parque_rio_negro));
        pois.add(new PoI(getString(R.string.square_name_3), getString(R.string.square_description_3), R.drawable.parque_senador_jefferson_peres));
        pois.add(new PoI(getString(R.string.square_name_5), getString(R.string.square_description_5), R.drawable.praca_heliodoro_balbi));

        PoIAdapter adapter = new PoIAdapter(getActivity(), pois, R.color.category_square);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PoI poi = pois.get(position);

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("poi", poi);
                startActivity(i);
            }
        });

        return rootView;
    }

}
