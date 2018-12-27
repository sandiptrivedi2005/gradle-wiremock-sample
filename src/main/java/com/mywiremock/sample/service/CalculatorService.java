package com.mywiremock.sample.service;

/**
 * Created by sandip.t on 12/27/2018.
 */
public class CalculatorService {

    public int add(int x, int y){
        if(x>100){
            x=50;
        }
        return Math.addExact(x,y);
    }

    public int subtract(int x, int y){
        return Math.subtractExact(x,y);
    }

}
