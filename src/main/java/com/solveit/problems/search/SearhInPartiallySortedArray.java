package com.solveit.problems.search;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * [1,2,3,4,5,6,7,8] -> [7,8,1,2,3,4,5,6] -> target = 5 => index or  -1
 */

public class SearhInPartiallySortedArray {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }

        int[] arr =  new int[] {7,8,9,2,3,4,5,6};
        int num = 7;

        System.out.println(searchIndex(arr, 7));
        System.out.println(searchIndex(arr, 9));
        System.out.println(searchIndex(arr, 8));

        System.out.println(searchIndex(arr, 2));
        System.out.println(searchIndex(arr, 4));
        System.out.println(searchIndex(arr, 5));
        System.out.println(searchIndex(arr, 6));

    }

    private static int searchIndex(int[] arr, int num) {

        int indexFlip = findIndexOfFlip(0, arr.length, arr);

        if(indexFlip != -1){
            if(arr[0] == num) {
                return 0;
            }

            if(arr[indexFlip] == num) {
                return indexFlip;
            }

            if(arr[arr.length -1] == num) {
                return arr.length -1;
            }

            if(num > arr[0] && num < arr[indexFlip]) {
                return binarySearch(0, indexFlip+1, arr, num);
            } else {
                return binarySearch(indexFlip+1, arr.length, arr, num);
            }
        } else {
            return binarySearch(0, arr.length, arr, num);
        }
    }

    private static int binarySearch(int fromIndex, int toIndex, int[] arr, int num) {
        return Arrays.binarySearch(arr, fromIndex, toIndex, num);
    }

/// 1 2 3  7 8 9

    //   7 8 9 1 2 3

    // int[] arr =  new int[] {7,8,1,2,3,4,5,6};


    private static int findIndexOfFlip(int floorIndex, int ceilIndex, int[] arr) {
        int mid = (floorIndex + ceilIndex ) /2;

        if(ceilIndex == (floorIndex + 1)){

            if(arr[ceilIndex] < arr[floorIndex]) {
                return floorIndex;
            } else {
                return -1;
            }
        }

        if(arr[mid] < arr[floorIndex]) {

            return findIndexOfFlip(floorIndex, mid, arr);

        } else if (arr[mid] > arr[ceilIndex]) {

            return findIndexOfFlip(mid, ceilIndex, arr);
        }



        return floorIndex;

    }
}
