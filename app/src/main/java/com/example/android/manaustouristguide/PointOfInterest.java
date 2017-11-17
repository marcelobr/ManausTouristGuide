package com.example.android.manaustouristguide;

import java.io.Serializable;

/**
 * Represents the Points of Interest (PointOfInterest) present in the tourist guide.
 */

public class PointOfInterest implements Serializable {

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Name of Point of Interest */
    private String mNameOfPoI;

    /** Description of Point of Interest */
    private String mDescriptionOfPoI;

    /** Image resource ID of Point of Interest */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new PointOfInterest object.
     * @param mNameOfPoI is the name of point of interest
     * @param mDescriptionOfPoI is the description of point of interest
     */
    public PointOfInterest(String mNameOfPoI, String mDescriptionOfPoI) {
        this.mNameOfPoI = mNameOfPoI;
        this.mDescriptionOfPoI = mDescriptionOfPoI;
    }

    /**
     * Create a new PointOfInterest object.
     * @param mNameOfPoI is the name of point of interest
     * @param mDescriptionOfPoI is the description of point of interest
     * @param mImageResourceId is the drawable resource ID for the image associated with the PointOfInterest
     */
    public PointOfInterest(String mNameOfPoI, String mDescriptionOfPoI, int mImageResourceId) {
        this.mNameOfPoI = mNameOfPoI;
        this.mDescriptionOfPoI = mDescriptionOfPoI;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmNameOfPoI() {
        return mNameOfPoI;
    }

    public String getmDescriptionOfPoI() {
        return mDescriptionOfPoI;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
