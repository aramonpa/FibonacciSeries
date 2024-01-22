package com.example.fibonacciseries;

import java.util.ArrayList;

public class Fibonacci {

    private final ArrayList<Long> numbers = new ArrayList<>();
    public Fibonacci() {
    }

    public long calculate(int pos) {
        long current = 1;
        long previous = 1;
        long result = 0;

        if (pos <= 2) {
            numbers.add(1L);
            return 1;
        }

        for (int i = 2; i < pos; i++) {
            result = current + previous;
            current = previous;
            previous = result;
            numbers.add(result);
        }

        return result;
    }

    public int sum() {
        int sum = 0;
        for (long l : numbers) {
            sum += l;
        }
        return sum;
    }

}
