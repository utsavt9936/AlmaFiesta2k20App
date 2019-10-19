package com.example.almafiesta2k20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.AvailableNetworkInfo;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.IOException;

public class galleryactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleryactivity);


        WebView myWebView = (WebView) findViewById(R.id.webview);

        myWebView.loadUrl("https://drive.google.com/drive/folders/1VFrmOPFLw2-2haq1DCgi4yMqyekpfBPZ?usp=sharing");
        finish();

    }



}
