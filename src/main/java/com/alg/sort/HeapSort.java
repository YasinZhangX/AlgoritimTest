package com.alg.sort;

import static com.alg.Util.ArrayUtil.exchange;

/**
 * @author Yasin Zhang
 */
public class HeapSort {

    public void heapSort(Integer[] A) {
        int heapSize = A.length;

        buildMaxHeap(A);

        for (int i = A.length-1; i >= 1; i--) {
            exchange(A, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(A, 0, heapSize);
        }
    }

    private void buildMaxHeap(Integer[] A) {
        int heapSize = A.length;
        for (int i = heapSize/2; i >= 0; i--) {
            maxHeapify(A, i, heapSize);
        }
    }

    private void maxHeapify(Integer[] A, int i, int heapSize) {
        int largest = -1;

        int l = getLeft(i);
        int r = getRight(i);

        if (l < heapSize && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && A[r] > A[largest]) {
            largest = r;
        }

        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(A, largest, heapSize);
        }
    }

    private int getParent(int index) {
        return index/2;
    }

    private int getLeft(int index) {
        return 2*index;
    }

    private int getRight(int index) {
        return 2*index+1;
    }

}
