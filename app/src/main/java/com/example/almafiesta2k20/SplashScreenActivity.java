package com.example.almafiesta2k20;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreenActivity extends AwesomeSplash {

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!

    @Override
    public void initSplash(ConfigSplash configSplash) {
        getSupportActionBar().hide();
        /* you don't have to override every property */

        /* you don't have to override every property */

        //Customize Circular Reveal
        // configSplash.setBackgroundColor(R.color.back);
        //any color you want form colors.xml
        //   configSplash.setAnimPathStrokeDrawingDuration(2000);
        //configSplash.setAnimCircularRevealDuration(2000); //int ms
        // configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        //configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo

        nameDbHelper mHelper=new nameDbHelper(this);
        SQLiteDatabase db=mHelper.getReadableDatabase();
        String []projection={"name"};
        final Cursor cursor=db.query("login",projection,null,null,null,null,null);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.activity_splashscreen);
        //this will bind your MainActivity.class file with activity_main.

        cursor.moveToFirst();

        configSplash.setLogoSplash(R.drawable.amlogo); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
        // configSplash.setPathSplash(SyncStateContract.Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3);
        configSplash.setPathSplashFillColor(R.color.Wheat); //path object filling color


        //Customize Title
        if(cursor.getCount()>0)
        configSplash.setTitleSplash(cursor.getString(cursor.getColumnIndex("name"))+'\n'+"Yo Alma"); //change your app name here
        else
            configSplash.setTitleSplash("Yo Alma"); //change your app name here


        configSplash.setTitleTextColor(R.color.Wheat);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setOriginalHeight(700);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);
        configSplash.setTitleFont("fonts/Pacifico.ttf"); //provide string to your font located in assets/fonts/
        if(cursor.getCount()>0)
            configSplash.setTitleSplash(cursor.getString(cursor.getColumnIndex("name"))+'\n'+"Yo Alma"); //change your app name here
        else
            configSplash.setTitleSplash("Yo Alma"); //change your app name here


        configSplash.setTitleTextColor(R.color.Wheat);
        configSplash.setTitleTextSize(30f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setOriginalHeight(700);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);
        configSplash.setTitleFont("fonts/Pacifico.ttf"); //provide string to your font located in assets/fonts/


    }

    @Override
    public void animationsFinished() {
        nameDbHelper mHelper=new nameDbHelper(this);
        SQLiteDatabase db=mHelper.getReadableDatabase();
        String []projection={"name"};
        final Cursor cursor=db.query("login",projection,null,null,null,null,null);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Intent is used to switch from one activity to another.
                Intent i;
                if(cursor.getCount()==0)
                    i=new Intent(SplashScreenActivity.this, LoginActivity.class);

                else
                    i=new Intent(SplashScreenActivity.this, MainActivity.class);

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, 2000);
        //transit to another activity here
        //or do whatever you want
    }
}