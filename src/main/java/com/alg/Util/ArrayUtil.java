package com.alg.Util;

/**
 * @author Yasin Zhang
 */
public class ArrayUtil {

    /**
     * 交换数组中的两个参数的位置
     */
    public static void exchange(Object[] A, int index1, int index2) {
        Object tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }

}
