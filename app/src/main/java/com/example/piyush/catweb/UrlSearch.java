package com.example.piyush.catweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class UrlSearch extends AppCompatActivity {

    private Button searchBtn,homeBtn;
    private EditText searchUrl;
    private WebView searchWeb;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);

        searchBtn=findViewById(R.id.search_btn);
        homeBtn=findViewById(R.id.home_btn);
        searchUrl=findViewById(R.id.search_url);
        searchWeb=findViewById(R.id.webView);

        url=getIntent().getExtras().get("url_address").toString();
        WebSettings webSettings=searchWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        searchWeb.loadUrl(url);
        searchWeb.setWebViewClient(new WebViewClient());




        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UrlSearch.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (searchWeb.canGoBack())
        {
            searchWeb.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
