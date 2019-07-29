package com.company;

import java.sql.Timestamp;


public class Main {


    private static final double EPSILON = 0.01D;

    public static void main(String[] args) {

        double[] koeficienty = new double[]{1,1,1,1,1};
        int range = 50000;
        for(int i=0;i<range; i++){
            long xx = faktoruj2(i);
            System.out.println(new Timestamp(System.currentTimeMillis())+": "+i+"! = "+xx);

            if(xx<0){
                System.out.println("spocitano max do radu k = "+(i-1));
                break;
            }
        }

        Polynom polynom = new Polynom(koeficienty);

        double xp = 1;
        double yp = polynom.evaluate(xp);
        System.out.println("hodnota polynomu v bode x=" + xp + " je rovna  f(x)=" + yp);


        Taylor taylor = new Taylor(koeficienty);
        double x = 1;
        double b = 0;
        double y = taylor.evaltaylor(x,b);
        System.out.println("Hodnota Taylorovy rady v bode x = " + x + " a se stredem b = " + b + " je rovna f(x)= " + y);

        double delta = Math.abs(y-Math.exp(x));
        System.out.println("rozdil od tridy java.math delta = "+delta+", rovnost = "+(delta<EPSILON));

        double w = newtonK(10, polynom, 1);
        System.out.println("Newton's X = "+w);




    }

    public static double newtonK (int k, Polynom polynom, double initialGuess){
        double x=0;
        Newton newton = new Newton(polynom, initialGuess);
        for (int i = 0; i<k; i++){
            newton.next();
            x = newton.x;
        }
        return x;
    }

    public double evaluate(Polynom polynom, double x) {

        return 0;
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

    public static long faktoruj2(long f) {

        if (f < 0) {
            return 0;
        }
        if (f < 2) {
            return 1;
        }
        long z = 2;

        for (int i = 3; i <= f; i++) {
            z = z * i;
        }
        return z;
    }




}








