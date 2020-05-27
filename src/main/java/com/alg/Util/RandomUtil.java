package com.alg.Util;

import java.util.Random;

/**
 * @author Yasin Zhang
 */
public class RandomUtil {

    private Random random;

    public RandomUtil() {
        random = new Random();
    }

    public RandomUtil(long seed) {
        random = new Random(seed);
    }

    public int nextInt(int lowerBound, int upperBound) {
        return random.nextInt(upperBound-lowerBound+1) + lowerBound;
    }

    public double nextDouble() {
        return random.nextDouble();
    }

    public double internalNextDouble(double origin, double bound) {
        double r = random.nextDouble();
        if (origin < bound) {
            r = r * (bound - origin) + origin;
            if (r >= bound) { // correct for rounding
                r = Double.longBitsToDouble(Double.doubleToLongBits(bound) - 1);
            }
        }
        return r;
    }

}
