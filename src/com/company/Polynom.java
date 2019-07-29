package com.company;

public class Polynom {

    public double[] a;
    // f

    public Polynom(){

    }

    public Polynom(double[] a) {

        this.a = a;
    }

    public double evaluate(double x) {


        double y = 0;
        double z = 1;
        for (int m = 0; m < a.length; m++) {
            y += a[m] * z;
            z *= x;
        }
        return y;
    }
}



