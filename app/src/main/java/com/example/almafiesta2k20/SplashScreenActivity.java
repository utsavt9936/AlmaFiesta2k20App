package com.example.almafiesta2k20;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        nameDbHelper mHelper=new nameDbHelper(this);
        SQLiteDatabase db=mHelper.getReadableDatabase();
        String []projection={"name"};
        final Cursor cursor=db.query("login",projection,null,null,null,null,null);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.activity_splash_screen);
        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent is used to switch from one activity to another.
                Intent i;
                if(cursor.getCount()==0)
                    i=new Intent(SplashScreenActivity.this,LoginActivity.class);

                else
                    i=new Intent(SplashScreenActivity.this,MainActivity.class);

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, 2000);

    }
}
