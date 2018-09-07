package com.solveit.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    // keep the previous sum
    // minus the one from sum
    // add the new one to sum
    // divide by sliding window range

    private int window = 1;
    private double prevSum = 0;

    int ci = -1;

    int count = 0;

    int[] arr = null;
//    private Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] arg) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(2));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(20));
    }

    public MovingAverage(int window) {
        this.window = window;
        arr = new int[window];
    }

    public double next(int element) {
//        if(window == 0) {
//            return 0;
//        }
        ci = (ci +1) % window;

        if(count < window) {
            count = count + 1;
            prevSum = (prevSum + element);
            arr[ci] = element;
           return  prevSum / count ;
        }else {

            int polled = arr[ci];
            prevSum = prevSum - polled;
            prevSum = prevSum + element;
            arr[ci] = element;
            return prevSum / window ;
        }
    }

}
