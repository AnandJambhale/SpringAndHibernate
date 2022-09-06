package com.comapny;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReader {
    public static void main(String[] args) throws ParseException, IOException {
        JSONParser parser=new JSONParser();

        JSONObject obj=(JSONObject) parser.parse(new FileReader("file.json"));

        ArrayList list=new ArrayList<>();
        list.add(obj.get("item_id"));

        JSONArray array=(JSONArray)obj.get("children");
        obj=(JSONObject) array.get(0);
        list.add(obj.get("item_id"));

        array=(JSONArray)obj.get("children");
        obj=(JSONObject) array.get(0);
        list.add(obj.get("item_id"));

        JSONArray array1=(JSONArray)obj.get("children");
        JSONObject obj1=(JSONObject) array1.get(0);
        list.add(obj1.get("item_id"));

        obj1=(JSONObject) array1.get(1);
        list.add(obj1.get("item_id"));

        obj=(JSONObject)array.get(1);
        list.add(obj.get("item_id"));

        System.out.println(list);
    }
}
