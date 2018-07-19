package com.github.headnews;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//处理Json数据结构:将得到的从服务器传来的消息 转化为集合
public class NewsJSON {
	
	private ArrayList<Header> headers;


	//构造方法 --> 构造这个类对象的方法
	//只要NewsJson 被创建对象一定使用这方法
	public NewsJSON(String jsonContent){
		headers = new ArrayList<>();

		//jsonContent接收外部的传值
		//JSONParser 解析json
		JSONParser(jsonContent);
	}

	//通过该方法得到集合
	public ArrayList<Header> getHeaders(){

		return headers;
	}
	
	private void JSONParser(String jsonContent){
		//判断收到的json是否为空
		if(jsonContent.length() != 0 && jsonContent != ""){

			//将整个JSON结构数据抽象化为一个JSONObject对象
			//从数据转化为对象，可以更加结构化整体数据，便于遍历
			JSONObject object = JSON.parseObject(jsonContent);

			//JSONArray 数组对象
			JSONArray array = object.getJSONObject("result").getJSONArray("data");

			for(int i = 0; i < array.size(); i++){
				Header header = new Header();
				JSONObject headerObj = array.getJSONObject(i);
				header.setTitle(headerObj.getString("title"));
				header.setDate(headerObj.getString("date"));
				header.setAuthor_name(headerObj.getString("author_name"));
				header.setThumbnail_pic_s(headerObj.getString("thumbnail_pic_s"));
				header.setThumbnail_pic_s02(headerObj.getString("thumbnail_pic_s02"));
				header.setThumbnail_pic_s03(headerObj.getString("thumbnail_pic_s03"));
				header.setUrl(headerObj.getString("url"));
				header.setUniquekey(headerObj.getString("uniquekey"));
				header.setType(headerObj.getString("type"));
				header.setRealtype(headerObj.getString("realtype"));
				headers.add(header);
			}
			System.out.println(headers.toString());
		}
		
	}
	
}
