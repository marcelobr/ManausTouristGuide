package com.example.android.manaustouristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the Intent that started this activity and extract the object
        Intent intent = getIntent();
        PoI poi = (PoI) intent.getSerializableExtra("poi");

        ImageView imagePoI = (ImageView) findViewById(R.id.list_item_image);
        Glide.with(this)
                .load(poi.getmImageResourceId())
                .into(imagePoI);
        //imagePoI.setImageResource(poi.getmImageResourceId());

        TextView textPoI = (TextView) findViewById(R.id.list_item_text);
        textPoI.setText(poi.getmNameOfPoI());

        TextView descriptionPoI = (TextView) findViewById(R.id.list_item_description);
        descriptionPoI.setText(poi.getmDescriptionOfPoI());
    }
}
