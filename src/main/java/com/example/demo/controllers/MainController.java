package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.responses.MainResponce;

import com.example.demo.exception.ServiceException;
import com.example.demo.service.Calculation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/number")
    public MainResponce greeting(@RequestParam(value = "digit", defaultValue = "0") int digit) throws ServiceException {
        if(digit<=0){
            throw new ServiceException("illegal argument : digit <=0 ");
        }
        var tempObj = new Calculation();
        boolean even = tempObj.isEven(digit);
        boolean simple = tempObj.isSimple(digit);

        return new MainResponce(counter.incrementAndGet(),digit,even,simple);
    }
}
