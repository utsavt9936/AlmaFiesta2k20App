package com.example.almafiesta2k20;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Music", "Dance", "Dramatics","Literary","Fine Arts","Photography"};
    public fragAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new musicfragment();
        } else if (position == 1){
            return new dancefragment();
        } else if (position == 2) {
            return new dramsfragment();
        }
        else if (position == 3) {
            return new litfragment();
        }
        else if (position == 4) {
            return new finefragment();
        }
        else if (position == 5) {
            return new photofragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
