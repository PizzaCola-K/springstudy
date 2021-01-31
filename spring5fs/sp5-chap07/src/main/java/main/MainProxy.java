package main;

import chap07.Calculator;
import chap07.ExeTimeCalculator;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class MainProxy {
    public static void main(String[] args) {
        Calculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
        Calculator ttCal2 = new ExeTimeCalculator(new RecCalculator());

        System.out.println(ttCal1.factorial(20));
        System.out.println(ttCal2.factorial(20));

    }
}
