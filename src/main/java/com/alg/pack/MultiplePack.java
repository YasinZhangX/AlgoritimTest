package com.alg.pack;

/**
 * @author Yasin Zhang
 */
public class MultiplePack {
    public int solution(int V, int N, int[] M, int[] C, int[] W) {
        int[] F = new int[V+1];
        for (int i = 1; i <= N; i++) {
            multiplePack(F, C[i-1], W[i-1], M[i-1], V);
        }

        return F[V];
    }

    private static void multiplePack(int[] F, int C, int W, int M, int V) {
        if (C * M >= V) {
            CompletePack.completePack(F, C, W, V);
            return;
        }

        int k = 1;
        while (k < M) {
            ZeroOnePack.zeroOnePack(F, k*C, k*W, V);
            M = M - k;
            k = 2 * k;
        }
        ZeroOnePack.zeroOnePack(F, C*M, W*M, V);
    }
}
