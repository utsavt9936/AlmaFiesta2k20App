package com.example.almafiesta2k20;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class imageLoader extends AsyncTaskLoader<ArrayList<Bitmap>> {
    public imageLoader(Context context)
    {
        super(context);
    }


    @Override
    public ArrayList<Bitmap> loadInBackground() {
        ArrayList<Bitmap> imlist=new ArrayList<Bitmap>();
        imlist.add(fetchImage(getContext().getResources().getString(R.string.im1)));
        imlist.add(fetchImage(getContext().getResources().getString(R.string.im2)));
        imlist.add(fetchImage(getContext().getResources().getString(R.string.im3)));
        imlist.add(fetchImage(getContext().getResources().getString(R.string.im4)));
        return imlist;
    }

    private Bitmap fetchImage(String str){
        URL url=null;
        Bitmap bmp=null;
        InputStream inputStream=null;
        try
        {
            url = new URL(str);
        }
        catch (MalformedURLException e)
        {
            Log.v("a","b");
        }
        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream=url.openConnection().getInputStream();
                bmp = BitmapFactory.decodeStream(inputStream);

            } else {
                Log.e("a", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("a", "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream!= null) {
                try
                {
                    inputStream.close();
                }
                catch(IOException e)
                {
                    Log.e("a", "Problem retrieving the earthquake JSON results.", e);

                }
            }
        }
        return bmp;
    }
}
