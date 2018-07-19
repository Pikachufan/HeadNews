package com.github.headnews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class webview extends AppCompatActivity implements View.OnClickListener{

    private WebView webView;
    private ImageView imageView;
    private TextView textView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //去掉ActionBar(标题栏)
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");

        webView = (WebView)findViewById(R.id.webview);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);

//        webSettings = webView.getSettings();
//        设置支持JS
//        webSettings.setJavaScriptEnabled(true);

        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);

//        设置在当前页面加载
        webView.setWebViewClient(new WebViewClient());
//        加载网址
        webView.loadUrl(url);




    }



//    @Override
    //支持网页返回
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack())
//        {
//            webView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onClick(View v) {

        finish();

    }
}
