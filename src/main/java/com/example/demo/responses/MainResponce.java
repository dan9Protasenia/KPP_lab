package com.example.demo.responses;

import com.example.demo.process.OutputParams;

public class MainResponce {
    private final long id;
    private final int number;
    private final OutputParams params;

    public MainResponce(long id, int number,OutputParams params) {
        this.id = id;
        this.number = number;
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public OutputParams getParams() { return params; }
}

