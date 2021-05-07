package com.example.covid19_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BreakingNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breaking_news);


        WebView coronaWebView = (WebView) findViewById(R.id.webNews);
        String url = "https://www.bbc.com/news/coronavirus";
        coronaWebView.getSettings().setJavaScriptEnabled(true);
        coronaWebView.setWebViewClient(new WebViewClient());
        coronaWebView.loadUrl(url + "");
    }
}