package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.example.demo.SpringConfig;
import com.example.demo.cache.Cache;
import com.example.demo.logger.MyLogger;
import com.example.demo.process.OutputParams;
import com.example.demo.responses.MainResponce;

import com.example.demo.exception.ServiceException;
import com.example.demo.responses.StatisticsResponse;
import com.example.demo.service.Calculation;
import com.example.demo.сounter.Counter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static List<MainResponce> list = new ArrayList<>();

    Calculation calc = new Calculation();

    Cache cache;
    Counter counterService;

    @Autowired
    public void setCounter(Counter counter) {
        this.counterService = counter;
    }

    @Autowired
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @GetMapping("/number")
    public ResponseEntity<MainResponce> greeting(@RequestParam(value = "digit", defaultValue = "0") int digit){
        //Метод getBean() может принимать в качестве аргумента как класс, так и названия бина
        if (digit <= 0) {
            throw new ServiceException("illegal argument : digit <=0 ");
        }
        counterService.inc();
        MyLogger.warn("Counter"+counterService.getRequestsCount());
        OutputParams params;
        if (cache.containsKey(digit)) {
            params = cache.get(digit);
            MyLogger.info("Result already in cache");
            return new ResponseEntity<>(new MainResponce(params),HttpStatus.OK);
        } else {
            MyLogger.info("Result calculated");
            return new ResponseEntity<>(calc.process(digit), HttpStatus.OK);
        }
    }

    @PostMapping("/number_bulk")
    public ResponseEntity<Object> bulkOperation(@RequestBody @NotNull List<Integer> params){
        list.clear();
        list = params
                .stream()
                .map(calc::process)
                .collect(Collectors.toList());
        MyLogger.warn("List:"+list);
        counterService.inc();
        MyLogger.info("Counter:"+ counterService.getRequestsCount());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/last_stat")
    public ResponseEntity<Object> lastStatistics() {
        return new ResponseEntity<>(StatisticsResponse.getResponse(), HttpStatus.OK);
    }
}
