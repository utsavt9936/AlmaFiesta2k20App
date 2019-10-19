package com.example.almafiesta2k20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;

public class eventsactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        // set an exit transition
        getWindow().setExitTransition(new Fade());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsactivity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragAdapter adapter = new fragAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }
}
