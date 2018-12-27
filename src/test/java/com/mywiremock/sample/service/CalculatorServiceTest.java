package com.mywiremock.sample.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sandip.t on 12/27/2018.
 */
public class CalculatorServiceTest {

    CalculatorService service;

    @Before
    public void init(){
        service = new CalculatorService();
    }

    @Test
    public void testAddition(){
       int result =  service.add(3,4);
        assertEquals(7, result);
    }

    @Test
    public void testSubtraction(){
       int result =  service.subtract(3,4);
        assertEquals(-1, result);
    }
}
