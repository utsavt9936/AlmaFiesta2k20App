package com.example.almafiesta2k20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.viewpager.widget.ViewPager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Bitmap>> {
    public int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=(ImageView)findViewById(R.id.imgs);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);

        FloatingActionButton fb=(FloatingActionButton)findViewById(R.id.fb);
        FloatingActionButton youtube=(FloatingActionButton)findViewById(R.id.youtube);
        FloatingActionButton insta=(FloatingActionButton)findViewById(R.id.insta);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/221147295821"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/almafiesta/")));
                }

            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.instagram.com/almafiesta.iitbbs/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/almafiesta.iitbbs/")));
                }

            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCVAHFAfxXx0ZaOyS5VczKiA/featured"));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCVAHFAfxXx0ZaOyS5VczKiA/featured"));
                    startActivity(intent);
                }

            }
        });
        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.pages);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionButton floatingActionButton1=(FloatingActionButton)findViewById(R.id.fb);
                FloatingActionButton floatingActionButton2=(FloatingActionButton)findViewById(R.id.insta);
                FloatingActionButton floatingActionButton3=(FloatingActionButton)findViewById(R.id.youtube);
                if(i%2==0)
                {floatingActionButton1.show();
                    floatingActionButton2.show();
                    floatingActionButton3.show();
                    i++;
                }
                else
                {floatingActionButton1.hide();
                    floatingActionButton2.hide();
                    floatingActionButton3.hide();
                  i++;
                }

            }
        });


        LoaderManager.getInstance(this).initLoader(0,null,this).forceLoad();




    }



    @Override
    public Loader<ArrayList<Bitmap>> onCreateLoader(int id,  Bundle args) {
        ProgressBar pgbar=(ProgressBar)findViewById(R.id.pgb);
        pgbar.setVisibility(View.VISIBLE);
        return new imageLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished( Loader<ArrayList<Bitmap>> loader, ArrayList<Bitmap> data) {
        ProgressBar pgbar=(ProgressBar)findViewById(R.id.pgb);
        pgbar.setVisibility(View.GONE);
        ImageView imageView=(ImageView)findViewById(R.id.imgs);
        imageView.setImageBitmap(data.get(0));


    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Bitmap>> loader) {

        ImageView imageView=(ImageView)findViewById(R.id.imgs);
        imageView.setImageResource(R.drawable.ic_launcher_background);
    }




}
