package com.example.demo.service;

import com.example.demo.logger.MyLogger;

public class Calculation {
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
}
