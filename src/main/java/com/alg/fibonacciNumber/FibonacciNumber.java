package com.alg.fibonacciNumber;

/**
 * @author Yasin Zhang
 */
public class FibonacciNumber {

    Matrix2 origin = new Matrix2(1, 1, 1, 0);

    public int calcFibonacciNum(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        Matrix2 result = new Matrix2(1, 0, 0, 1);  // 单位矩阵
        for (int i = 1; i <= n; i++) {
            result = Matrix2.mul(result, origin);
        }
        return result.getM12();
    }

}
