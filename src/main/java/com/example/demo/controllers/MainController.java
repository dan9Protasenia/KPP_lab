package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.SpringConfig;
import com.example.demo.cache.Cache;
import com.example.demo.logger.MyLogger;
import com.example.demo.process.OutputParams;
import com.example.demo.responses.MainResponce;

import com.example.demo.exception.ServiceException;
import com.example.demo.service.Calculation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/number")
    public MainResponce greeting(@RequestParam(value = "digit", defaultValue = "0") int digit) throws ServiceException {
        Cache cache = context.getBean("cache", Cache.class);
        if (digit <= 0) {
            throw new ServiceException("illegal argument : digit <=0 ");
        }
        var tempObj = new Calculation();

        OutputParams params;
        if (cache.containsKey(digit)) {
            params = cache.get(digit);
            MyLogger.info("Result already in cache");
        } else {
            boolean even = tempObj.isEven(digit);
            boolean simple = tempObj.isSimple(digit);
            params = new OutputParams(even, simple);
            MyLogger.info("Result calculated");
        }


        return new MainResponce(counter.incrementAndGet(), digit, params);
    }


}
