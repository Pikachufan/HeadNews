package com.github.headnews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ListView listView;
    private String result;
    private String type = "top";

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;

    private ArrayList<Header> list = new ArrayList<Header>();



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //服务器数据已被收到
            //创建NewsJson对象
            NewsJSON nj = new NewsJSON(result);
            list = nj.getHeaders();
            MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
            listView.setAdapter(myAdapter);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //去掉ActionBar(标题栏)
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.header_list);



//        HeadNewsRequest hr = new HeadNewsRequest();
//        String str = hr.getRequestResult();

        initView();
        setTextColor();
        RequestTheard rt = new RequestTheard();
        rt.start();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
//                String url = list.get(position).getUrl();
                intent.putExtra("url",list.get(position).getUrl());
                intent.setClass(MainActivity.this,webview.class);
                startActivity(intent);
            }
        });
    }

    public void initView(){

        textView1 = (TextView) findViewById(R.id.top);
        textView2 = (TextView)findViewById(R.id.shehui);
        textView3 = (TextView)findViewById(R.id.guonei);
        textView4 = (TextView)findViewById(R.id.guoji);
        textView5 = (TextView)findViewById(R.id.yule);
        textView6 = (TextView)findViewById(R.id.tiyu);
        textView7 = (TextView)findViewById(R.id.junshi);
        textView8 = (TextView)findViewById(R.id.keji);
        textView9 = (TextView)findViewById(R.id.caijing);
        textView10 = (TextView)findViewById(R.id.shishang);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);
        textView10.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.top:
                type = "top";
                setTextColor();
                textView1.setTextColor(Color.RED);
                RequestTheard rt1 = new RequestTheard();
                rt1.start();
                break;
            case R.id.shehui:
                type = "shehui";
                setTextColor();
                textView2.setTextColor(Color.RED);
                RequestTheard rt2 = new RequestTheard();
                rt2.start();
                break;
            case R.id.guonei:
                type = "guonei";
                setTextColor();
                textView3.setTextColor(Color.RED);
                RequestTheard rt3 = new RequestTheard();
                rt3.start();
                break;
            case R.id.guoji:
                type = "guoji";
                setTextColor();
                textView4.setTextColor(Color.RED);
                RequestTheard rt4 = new RequestTheard();
                rt4.start();
                break;
            case R.id.yule:
                type = "yule";
                setTextColor();
                textView5.setTextColor(Color.RED);
                RequestTheard rt5 = new RequestTheard();
                rt5.start();
                break;
            case R.id.tiyu:
                type = "tiyu";
                setTextColor();
                textView6.setTextColor(Color.RED);
                RequestTheard rt6 = new RequestTheard();
                rt6.start();
                break;
            case R.id.junshi:
                type = "junshi";
                setTextColor();
                textView7.setTextColor(Color.RED);
                RequestTheard rt7 = new RequestTheard();
                rt7.start();
                break;
            case R.id.keji:
                type = "keji";
                setTextColor();
                textView8.setTextColor(Color.RED);
                RequestTheard rt8 = new RequestTheard();
                rt8.start();
                break;
            case R.id.caijing:
                type = "caijing";
                setTextColor();
                textView9.setTextColor(Color.RED);
                RequestTheard rt9 = new RequestTheard();
                rt9.start();
                break;
            case R.id.shishang:
                type = "shishang";
                setTextColor();
                textView10.setTextColor(Color.RED);
                RequestTheard rt0 = new RequestTheard();
                rt0.start();
                break;
        }

    }

    class RequestTheard extends Thread{
        @Override
        public void run() {
            HeadNewsRequest hr = new HeadNewsRequest();
            result = hr.getRequestResult(type);
            handler.sendEmptyMessage(0);
        }
    }

    public void setTextColor(){
        textView1.setTextColor(Color.BLACK);
        textView2.setTextColor(Color.BLACK);
        textView3.setTextColor(Color.BLACK);
        textView4.setTextColor(Color.BLACK);
        textView5.setTextColor(Color.BLACK);
        textView6.setTextColor(Color.BLACK);
        textView7.setTextColor(Color.BLACK);
        textView8.setTextColor(Color.BLACK);
        textView9.setTextColor(Color.BLACK);
        textView10.setTextColor(Color.BLACK);
    }

}
