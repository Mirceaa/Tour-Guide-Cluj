package com.mirceamoldovan.tourguidecluj;

public class Landmarks {

    private int mLandmarkName;
    private int mAddress;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Landmarks(int landmarkname, int address, int audioResourceId) {
        mLandmarkName = landmarkname;
        mAddress = address;
        mAudioResourceId = audioResourceId;
    }

    public Landmarks(int landmarkname, int address, int imageResourceId, int audioResourceId) {
        mLandmarkName = landmarkname;
        mAddress = address;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public int getLandmarkName() { return mLandmarkName; }

    public int getAddress(){ return mAddress; }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}

