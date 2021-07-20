package com.example.associateandroiddeveloper2020practiceproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import Activities.LearningFragment;
import Activities.SkillFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumberOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:return new LearningFragment();
            case 1:return new SkillFragment();
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
