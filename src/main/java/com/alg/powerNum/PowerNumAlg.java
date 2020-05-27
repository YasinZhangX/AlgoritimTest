package com.alg.powerNum;

public class PowerNumAlg {

    public Integer power(int x, int n) {
        if (n <= 1) {
            return x;
        }

        if (isEven(n)) {
            return power(x, n/2) * power(x, n/2);
        } else {
            return power(x, (n-1)/2) * power(x, (n-1)/2) * x;
        }
    }
    
    private boolean isEven(Integer n) {
        return (n%2 == 0);
    }
    
}
