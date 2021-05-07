package com.example.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        WebView coronaWebView = (WebView) findViewById(R.id.coronaWebView);
        String url = "https://www.bing.com/covid/local/egypt";
        coronaWebView.getSettings().setJavaScriptEnabled(true);
        coronaWebView.setWebViewClient(new WebViewClient());
        coronaWebView.loadUrl(url + "");


    }
}