package com.company;

import com.company.Polynom;

public class Newton{

    Polynom polynom;
    public double x;

    public Newton(Polynom polynom, double initialGuess) {
        this.polynom = polynom;
        this.x = initialGuess;
    }

    public void next() {
        x = x-(polynom.evaluate(x)/derivativeAtPoint(x));
    }

    public double derivativeAtPoint (double x) {
        double y = 0;
        double z = 1;
        for (int m = 0; m < this.polynom.a.length-1; m++) {
            y += this.polynom.a[m+1] * z;
            z *= x;
        }
        return y;
    }


    }

