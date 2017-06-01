package com.example.android.miwok;

/**
 * Created by Gravity on 5/29/2017.
 */

public class Word {

    private String mMiwokWord;
    private String mEnglishWord;
    private int mImageresourceId = NO_IMAGE_RESOURSE;
    private int mAudioResourceId;

    private static final int NO_IMAGE_RESOURSE = -1;

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }

    public int getImageresourceId() {
        return mImageresourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public Word(String miwokWord, String englishWord, int imageResource, int audioResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mImageresourceId = imageResource;
        mAudioResourceId = audioResourceId;
    }


    public Word(String miwokWord, String englishWord, int audioResourceId) {
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mAudioResourceId = audioResourceId;
    }

    public boolean hasImage() {
        return mImageresourceId != NO_IMAGE_RESOURSE;
    }
}
