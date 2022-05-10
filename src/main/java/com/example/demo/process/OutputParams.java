package com.example.demo.process;



public class OutputParams {

    private final Boolean simple;
    private final Boolean even;

    public OutputParams(
             Boolean even,
             Boolean simple
    ) {
        this.simple = simple;
        this.even = even;
    }
    public boolean getEven() {return even; }
    public boolean getSimple() {return simple; }
}
