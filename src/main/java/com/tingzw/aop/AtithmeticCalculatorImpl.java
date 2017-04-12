package com.tingzw.aop;

import org.springframework.stereotype.Component;

/**
 * @author tingzw
 * @date 2017-03-01 10:23
 **/
@Component
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
