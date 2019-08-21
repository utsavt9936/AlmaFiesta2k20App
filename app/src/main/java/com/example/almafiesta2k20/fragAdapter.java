package com.example.almafiesta2k20;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Events", "Sponsors", "Schedule"};
    public fragAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new eventsFragment();
        } else if (position == 1){
            return new sponcersFragment();
        } else if (position == 2) {
            return new scheduleFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
