package com.zt.json;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zt.json.bean.Score;
import com.zt.json.bean.Student;

public class Test {
	private final  static String TAG = "TEST";
	
	public static void main(String[] args) throws JSONException, IOException {
		
		ArrayList<Score> scores = new ArrayList<>();
		scores.add(new Score(1, 98, 1));
		Student student = new Student(23, "wangxiaoer",scores,"Henan");
		
//		createJson(student);
		createGson(student);
//		createJsonFromBean(student);
//		createJsonFromMap(student);
//		createJsonFromFile();
		
//		System.out.println("-----------------------");
//		createGsonFromBean(student);
		
	}
	
	public static JSONObject createJson(Student student) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("age", student.getAge());
		jsonObject.put("name", student.getName());
		jsonObject.put("scores", student.getScores());
		System.out.println(jsonObject);
		
		return jsonObject;
			
	}
	
	
	public static void  createGson(Student student) throws JSONException{
		System.out.println("createGson");
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
//		Gson gson  = new Gson();
		gson.toJson(student);
		
		System.out.println(gson.toJson(student));
		
	
			
	}

	public static JSONObject createJsonFromBean(Student student){
		System.out.println(new JSONObject(student).toString());
		return new JSONObject(student);
			
	}
	
	public static JSONObject createJsonFromMap(Student student){
		Map<String, String> scores = new HashMap<>();
		scores.put("classID", String.valueOf(student.getScores().get(0).getClassID()));
		scores.put("scores", String.valueOf(student.getScores().get(0).getScores()));
		scores.put("rank", String.valueOf(student.getScores().get(0).getRank()));
		
		Map<String, String> stu = new HashMap<>();
		stu.put("age", String.valueOf(student.getAge()));
		stu.put("name", student.getName());
		stu.put("scores", scores.toString());
		
		System.out.println(new JSONObject(stu));
		return new JSONObject(stu);
			
	}
	
	
	public static JSONObject createJsonFromFile() throws IOException, JSONException{
		File file = new File(Test.class.getResource("/Student.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println(jsonObject);
		return jsonObject;
	}
	
	
	public static Gson createGsonFromBean(Student student) throws JSONException{
		Gson gson = new Gson();
		Student stu = new Student(23, "xx");
		gson.toJson(stu);
		System.out.println(gson);
		
		return gson;
			
	}
	
	
}
