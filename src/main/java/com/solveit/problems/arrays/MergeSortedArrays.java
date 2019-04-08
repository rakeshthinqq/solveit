package com.solveit.problems.arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        // combine the sorted arrays into one large sorted array

        // 1    2   5
        // 3    6   8

        int p1= 0;
        int p2 = 0;

        int[] result = new int[myArray.length + alicesArray.length];

        int j = 0;

        while(p1< myArray.length || p2 < alicesArray.length) {

            if(p1 >= myArray.length){
                result[j] = alicesArray[p2];
                ++p2;

            } else if (p2 >= alicesArray.length) {
                result[j] = myArray[p1];
                ++p1;
            } else if(myArray[p1] < alicesArray[p2]) {
                result[j] = myArray[p1];
                ++p1;
            } else {
                result[j] = alicesArray[p2];
                ++p2;
            }
            j++;
        }


        return result;
    }


    /**
     *       final int[] myArray = {2, 4, 6, 8};
     *         final int[] alicesArray = {1, 7};
     *
     *
     * 1 >> R = 1, P2=1, P1=0
     * 2 >> R = 1 2, P1=1, P2=1
     * 3 >> R = 1 2 4, P1=2, P2=1
     * 4 >> R = 1 2 4 6, P1=3, P2=1
     * 5 >> R = 1 2 4 6 7, P1=3, P2=2
     * 6 >> R = 1 2 4 6 7 8, P1=4, P2=2
     *
     *
     *
     *
     */
















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MergeSortedArrays.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
