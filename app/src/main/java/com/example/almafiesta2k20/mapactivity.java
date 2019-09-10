package com.example.almafiesta2k20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class mapactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapactivity);

        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.loadUrl("https://www.google.com/maps/@20.1481339,85.6707391,16z");
        myWebView.getSettings().setJavaScriptEnabled(true);
    }
}
