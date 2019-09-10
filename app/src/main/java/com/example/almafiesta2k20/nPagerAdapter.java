package com.example.almafiesta2k20;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.almafiesta2k20.R;

import java.util.Timer;
import java.util.TimerTask;


public class nPagerAdapter extends PagerAdapter {
    private Context context;
    public nPagerAdapter(Context context) {
        this.context=context;
    }
    /*
    This callback is responsible for creating a page. We inflate the layout and set the drawable
    to the ImageView based on the position. In the end we add the inflated layout to the parent
    container .This method returns an object key to identify the page view, but in this example page view
    itself acts as the object key
    */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.image, null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(getImageAt(position));
        container.addView(view);
        return view;
    }

    Handler handler=new Handler();
    public Timer swipeTimer;

    public void setTimer(final ViewPager myPager, int time) {
        final int size = getCount();
        final Runnable Update = new Runnable() {
            int NUM_PAGES = size;
            int currentPage = 0;

            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                myPager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, time * 1000);
    }

    /*
    This callback is responsible for destroying a page. Since we are using view only as the
    object key we just directly remove the view from parent container
    */

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }
    /*
    Returns the count of the total pages
    */
    @Override
    public int getCount() {
        return 17;
    }
    /*
    Used to determine whether the page view is associated with object key returned by instantiateItem.
    Since here view only is the key we return view==object
    */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    private int getImageAt(int position) {
        switch (position%7) {
            case 0:
                return R.drawable.img5;
            case 1:
                return R.drawable.img1;
            case 2:
                return R.drawable.img3;
            case 3:
                return R.drawable.img4;
            case 4:
                return R.drawable.img2;
            case 5:
                return R.drawable.img6;
            case 6:
                return R.drawable.img7;
            default:
                return R.drawable.almalogo;
        }
    }
}
