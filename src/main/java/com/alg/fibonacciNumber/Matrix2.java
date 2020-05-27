package com.alg.fibonacciNumber;

/**
 * @author Yasin Zhang
 */
public class Matrix2 {

    private int m11;
    private int m12;
    private int m21;
    private int m22;

    Matrix2() {
        this.m11 = 0;
        this.m12 = 0;
        this.m21 = 0;
        this.m22 = 0;
    }

    public Matrix2(int m11, int m12, int m21, int m22) {
        this.m11 = m11;
        this.m12 = m12;
        this.m21 = m21;
        this.m22 = m22;
    }

    public static Matrix2 mul(Matrix2 A, Matrix2 B) {
        Matrix2 result = new Matrix2();
        result.setM11(A.getM11()*B.getM11() + A.getM12()*B.getM21());
        result.setM12(A.getM11()*B.getM12() + A.getM12()*B.getM22());
        result.setM21(A.getM21()*B.getM11() + A.getM22()*B.getM21());
        result.setM22(A.getM21()*B.getM12() + A.getM22()*B.getM22());
        return result;
    }

    @Override
    public String toString() {
        return "[ " + m11 + " " + m12 + " ]" + "\r\n" +
               "[ " + m21 + " " + m22 + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Matrix2.class) {
            Matrix2 tmp = (Matrix2) obj;
            return isEqual(tmp);
        }

        return false;
    }

    private boolean isEqual(Matrix2 m) {
        return this.m11 == m.getM11() && this.m12 == m.getM12() &&
               this.m21 == m.getM21() && this.m22 == m.getM22();
    }

    public int getM11() {
            return m11;
    }

    public void setM11(int m11) {
            this.m11 = m11;
    }

    public int getM12() {
            return m12;
    }

    public void setM12(int m12) {
            this.m12 = m12;
    }

    public int getM21() {
            return m21;
    }

    public void setM21(int m21) {
            this.m21 = m21;
    }

    public int getM22() {
            return m22;
    }

    public void setM22(int m22) {
            this.m22 = m22;
    }

}
