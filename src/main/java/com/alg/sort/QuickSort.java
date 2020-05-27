package com.alg.sort;

import com.alg.Util.RandomUtil;

import static com.alg.Util.ArrayUtil.exchange;

/**
 * @author Yasin Zhang
 */
public class QuickSort {

    public void quickSort(Integer[] A, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mainIndex = partition(A, startIndex, endIndex);
            quickSort(A, startIndex, mainIndex-1);
            quickSort(A, mainIndex+1, endIndex);
        }
    }

    public void randomizedQuickSort(Integer[] A, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mainIndex = randomizedPartition(A, startIndex, endIndex);
            quickSort(A, startIndex, mainIndex-1);
            quickSort(A, mainIndex+1, endIndex);
        }
    }

    /**
     * 返回主元位置,添加了随机
     */
    private int randomizedPartition(Integer[] A, int startIndex, int endIndex) {
        RandomUtil randomUtil = new RandomUtil();
        int i = randomUtil.nextInt(startIndex, endIndex);
        exchange(A, i, endIndex);
        return partition(A, startIndex, endIndex);
    }

    /**
     * 返回主元位置
     */
    private int partition(Integer[] A, int startIndex, int endIndex) {
        int x = A[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (A[j] <= x) {
                i = i + 1;
                exchange(A, i, j);
            }
        }
        exchange(A, i+1, endIndex);
        return i+1;
    }

}
