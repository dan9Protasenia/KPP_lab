package com.example.demo.responses;

public class MainResponce {
    private final long id;
    private final int number;
    private final boolean isEven;
    private final boolean isSimple;

    public MainResponce(long id, int number,boolean isEven,boolean isSimple) {
        this.id = id;
        this.number = number;
        this.isEven=isEven;
        this.isSimple=isSimple;
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsEven(){
        return isEven;
    }
    public boolean getIsSimple(){
        return isSimple;
    }
}
