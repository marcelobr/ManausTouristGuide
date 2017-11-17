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
        switch (position) {
            case 0:
                return new MostVisitedFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new ShoppingFragment();
            case 3:
                return new SquaresFragment();
            default:
                return new MostVisitedFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Get page title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_most_visited);
            case 1:
                return mContext.getString(R.string.category_restaurants);
            case 2:
                return mContext.getString(R.string.category_shopping);
            case 3:
                return mContext.getString(R.string.category_squares);
            default:
                return mContext.getString(R.string.category_most_visited);
        }
    }
}
