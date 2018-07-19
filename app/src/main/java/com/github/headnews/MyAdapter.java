package com.github.headnews;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.headnews.R;

import java.util.ArrayList;
import java.util.List;

import model.dataCache.BitmapCacheUtil;

//自定义适配器
public class MyAdapter extends BaseAdapter {


    Context context;
    ArrayList<Header> list;

    //生成构造器  （构造器 --> 当该创建对象时就会执行构造器方法）

    public MyAdapter(Context context, ArrayList<Header> list) {
        super();
        this.context = context;
        this.list = list;
    }

    //返回列表项数量
    @Override
    public int getCount() {

        return list.size();
    }

    //返回每个列表项的内容
    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    //返回每个列表的下标
    @Override
    public long getItemId(int position) {

        return position;
    }

    //返回每个列表项的布局
    //position 当前列表项的下标
    //convertView 当前列表项的布局
    //parent 当前列表项的容器
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //获取列表项的布局
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.header_item, parent, false);
            ImageView icon = (ImageView) convertView.findViewById(R.id.header_item_icon);
            TextView title = (TextView) convertView.findViewById(R.id.header_item_title);
            TextView author_time = (TextView) convertView.findViewById(R.id.header_item_author_title);
            convertView.setTag(new MyHolder(icon,title,author_time));
        }

        MyHolder holder = (MyHolder)convertView.getTag();
        Header header = list.get(position);
        holder.title.setText(header.getTitle());
        holder.author_time.setText(header.getAuthor_name() + "  " + header.getDate());

        //加载图片
        BitmapCacheUtil util = new BitmapCacheUtil();
        util.disPlay(holder.icon,header.getThumbnail_pic_s());

        return convertView;

    }

    //内部类
    class MyHolder {

        ImageView icon;
        TextView title;
        TextView author_time;

        public MyHolder(ImageView icon, TextView title, TextView author_time) {
            this.icon = icon;
            this.title = title;
            this.author_time = author_time;
        }

    }
}
