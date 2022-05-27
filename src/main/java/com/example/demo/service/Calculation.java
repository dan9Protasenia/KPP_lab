package com.example.demo.service;

import com.example.demo.logger.MyLogger;
import com.example.demo.process.OutputParams;
import com.example.demo.responses.MainResponce;


public class Calculation {
    Boolean isEven;
    Boolean isSimple;
    public boolean isEven(int number) {
        MyLogger.info("isEven calculated");
        return number % 2 == 0;
    }

    public boolean isSimple(int number) {
        if (number > 1) {
            if (number % 1 == 0 && number % number == 0) {
                MyLogger.info("isSimple verified");
                return true;
            }
        }
        return false;
    }

    public MainResponce process(int number) {
        isEven = number % 2 == 0;
        isSimple = number > 1 && (number % 1 == 0 && number % number == 0&&number%2!=0&&number%3!=0);
        return new MainResponce(new OutputParams(isEven,isSimple));
    }


    public MainResponce getResponse() {
        return new MainResponce(new OutputParams(isEven,isSimple));
    }
}
