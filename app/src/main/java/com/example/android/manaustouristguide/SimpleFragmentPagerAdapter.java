package com.example.android.manaustouristguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by marcelo on 07/11/17.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    // App Context
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Get fragment based on item position
        if (position == 0) {
            return new MostVisitedFragment();
        } else if (position == 1) {
            return new RestaurantFragment();
        } else if (position == 2) {
            return new ShoppingFragment();
        } else {
            return new SquaresFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Get page title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_most_visited);
        } else if (position == 1) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.category_shopping);
        } else {
            return mContext.getString(R.string.category_squares);
        }
    }

}
