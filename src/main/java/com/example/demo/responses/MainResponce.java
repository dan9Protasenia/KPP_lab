package com.example.demo.responses;

import com.example.demo.process.OutputParams;

public class MainResponce {
    private OutputParams params;

    public MainResponce(OutputParams params) {
        this.params = params;
    }

    public OutputParams getParams() {
        return params;
    }

    public void setParams(OutputParams params){
        this.params = params;
    }
}

