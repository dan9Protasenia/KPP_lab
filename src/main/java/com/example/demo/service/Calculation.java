package com.example.demo.service;

import java.math.BigInteger;

public class Calculation {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isSimple(int number) {
        if (number > 1) {
            if (number % 1 == 0 && number % number == 0) {
                return true;
            }
        }
        return false;
    }
}
