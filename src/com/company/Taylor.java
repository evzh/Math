package com.company;

public class Taylor {

        double[] a;
        // f

        public Taylor(double[] a) {

            this.a = a;
        }
    public static long faktoruj(long f) {
        if (f < 0) {
            return 0;
        }
        if (f < 2) {
            return 1;
        }
        return faktoruj(f - 1) * f;
    }
    public double evaltaylor(double x, double b) {
        double y = 0;
        double z = 1;
        for (int m = 0; m < a.length; m++) {
            y += a[m] * z/faktoruj(m);
            z *= x-b;
        }
        return y;
    }
}
