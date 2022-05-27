package com.example.demo.responses;

import com.example.demo.process.OutputParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.BinaryOperator;

import static com.example.demo.controllers.MainController.list;

@Getter
public class StatisticsResponse {
    @JsonProperty("Amount of requests")
    int requestsAmount;
    @JsonProperty("Number of even")
    int numEven;
    @JsonProperty("Number of simple")
    int numSimple;
    @JsonProperty("Most common response")
    OutputParams mostCommonResponse;

    public StatisticsResponse(int requestsAmount,int numEven,int numSimple, OutputParams mostCommon){
        this.requestsAmount = requestsAmount;
        this.numEven = numEven;
        this.numSimple = numSimple;
        this.mostCommonResponse = mostCommon;
    }

    public static Object getResponse() {
        MainResponce mostCommonResponse = list
                .stream()
                .reduce(
                        BinaryOperator.maxBy(Comparator.comparingInt(o -> Collections.frequency(list, o)))
                ).orElse(new MainResponce(new OutputParams(false,false)));
        OutputParams mostCommon = mostCommonResponse.getParams();

        int numberOfEven = 0;
        int numberOfSimple = 0;
        for(MainResponce i:list){
            if(i.getParams().getEven()==true)
                numberOfEven++;
            if(i.getParams().getSimple()==true)
                numberOfSimple++;
        }

        int requestsAmount = list.size();

        return new StatisticsResponse(requestsAmount,numberOfEven,numberOfSimple,mostCommon);
    }
}
