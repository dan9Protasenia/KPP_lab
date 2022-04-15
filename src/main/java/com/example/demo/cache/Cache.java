package com.example.demo.cache;

import com.example.demo.logger.MyLogger;
import com.example.demo.process.OutputParams;
import java.util.HashMap;


public class Cache {
    public static HashMap<Integer, OutputParams> map = new HashMap<>();
    public void put(OutputParams params, int input) {
        if (!map.containsKey(params)) {
            map.put(input, params);
            MyLogger.info("Key: " + params + " Value: " + input +  " is put in cache");
        }
        else {
            MyLogger.info("Responce is already in cache!");
        }
    }

    public OutputParams get(Integer vector) {

        var results = map.get(vector);
        MyLogger.info("Value: " + results + " is got from cache with Key: " + vector);
        return results;
    }

    public boolean containsKey(Integer digit){
        return map.containsKey(digit);
    }

    public void printMap(){
        System.out.println("Cache:"+map);
    }
}