package com.example.piyush.catweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText searchUrl;
    private Button search;

    private Button youtube,google,snapchat,yahoo,facebook,instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchUrl=findViewById(R.id.search_url_here);
        search=findViewById(R.id.search);

        youtube=findViewById(R.id.youtube_btn);
        yahoo=findViewById(R.id.yahoo_btn);
        google=findViewById(R.id.google_btn);
        snapchat=findViewById(R.id.snapchat_btn);
        facebook=findViewById(R.id.facebook_btn);
        instagram=findViewById(R.id.instagram_btn);

        search.setOnClickListener(this);
        yahoo.setOnClickListener(this);
        youtube.setOnClickListener(this);
        facebook.setOnClickListener(this);
        snapchat.setOnClickListener(this);
        google.setOnClickListener(this);
        instagram.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view==search)
        {
            OpenWebsite();
        }
        if (view==facebook)
        {
            Intent i=new Intent(HomeActivity.this,UrlSearch.class);
            i.putExtra("url_address","https://www.facebook.com");
            startActivity(i);
        }
        if (view==google)
        {
            Intent i1=new Intent(HomeActivity.this,UrlSearch.class);
            i1.putExtra("url_address","https://www.google.com");
            startActivity(i1);
        }
        if (view==yahoo)
        {
            Intent i2=new Intent(HomeActivity.this,UrlSearch.class);
            i2.putExtra("url_address","https://www.yahoo.com");
            startActivity(i2);
        }
        if (view==youtube)
        {
            Intent i3=new Intent(HomeActivity.this,UrlSearch.class);
            i3.putExtra("url_address","https://www.youtube.com");
            startActivity(i3);
        }
        if (view==snapchat)
        {
            Intent i4=new Intent(HomeActivity.this,UrlSearch.class);
            i4.putExtra("url_address","https://www.snapchat.com");
            startActivity(i4);
        }
        if (view==instagram)
        {
            Intent i5=new Intent(HomeActivity.this,UrlSearch.class);
            i5.putExtra("url_address","https://www.instagram.com");
            startActivity(i5);
        }
    }

    private void OpenWebsite()
    {
        String UrlAddress =searchUrl.getText().toString();

        if(TextUtils.isEmpty(UrlAddress))
        {
            Toast empty=Toast.makeText(HomeActivity.this,"Please enter url or search something",Toast.LENGTH_LONG);
            empty.show();
        }
        else
        {
            String url_without_http=UrlAddress.replaceAll("https://www.","");
            String https="https://";
            String www="www.";

            Intent i=new Intent(HomeActivity.this,UrlSearch.class);
            i.putExtra("url_address",https+www+url_without_http);
            startActivity(i);
        }
    }
}
