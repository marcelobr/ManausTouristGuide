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
        PointOfInterest pointOfInterest = (PointOfInterest) intent.getSerializableExtra("pointOfInterest");

        ImageView imagePoI = (ImageView) findViewById(R.id.list_item_image);
        Glide.with(this)
                .load(pointOfInterest.getmImageResourceId())
                .into(imagePoI);

        TextView textPoI = (TextView) findViewById(R.id.list_item_text);
        textPoI.setText(pointOfInterest.getmNameOfPoI());

        TextView descriptionPoI = (TextView) findViewById(R.id.list_item_description);
        descriptionPoI.setText(pointOfInterest.getmDescriptionOfPoI());
    }
}
