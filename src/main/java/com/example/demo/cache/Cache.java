package com.example.demo.cache;

import com.example.demo.logger.MyLogger;
import com.example.demo.process.OutputParams;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Cache {
    public static HashMap<Integer, OutputParams> map = new HashMap<>();
    public void put(OutputParams params, int input) {
        if (!map.containsKey(params)) {                 //containsKey вернет true, если в мапе есть такой ключ
            map.put(input, params);                     // метод добавления эллемента
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