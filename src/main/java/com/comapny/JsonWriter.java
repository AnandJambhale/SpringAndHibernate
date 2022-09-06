package com.comapny;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser=new JSONParser();

        JSONObject obj=(JSONObject) parser.parse(new FileReader("file.json"));

        JSONArray array=(JSONArray)obj.get("children");
        JSONObject obj1=(JSONObject) array.get(0);

        JSONArray array1=(JSONArray)obj1.get("children");
        JSONObject obj2=(JSONObject) array1.get(0);
        JSONObject obj3=(JSONObject) array1.get(1);

        JSONArray array2=new JSONArray();
        array2.add("Name"+":"+"Anand");
        array2.add("Mother"+":"+ "Mamta");
        array2.add("Father"+":"+"Vilas");

        obj2.putIfAbsent("details",array2);
        obj1.putIfAbsent("children",obj2);
        obj1.putIfAbsent("children",obj3);
        obj.putIfAbsent("children",obj1);
        //jsonArray for()
        //JsonArray array=new JSONArray();
        //for(int i=0;i<array.size();i++){
//               Object ob=array.get(i);
//               JSONObject jsonObject=(JSONObject)ob;
//               recursiveTraverser(jsonObject);
        //

        FileWriter writer=new FileWriter("file2.json");
        writer.write(obj.toJSONString());

        writer.close();

    }
}
