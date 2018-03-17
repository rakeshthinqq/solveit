package com.solveit.problems;

import java.util.*;

/**
 * Write a program to remove duplicates from sorted array.
 *
 *
 *
 */
public class RemoveDuplicates {

    public static void main(String[] arg) {
        //print(removeDuplicates(new int[]{1,2,3,3,5})); // 1,2,3,5
        /**
         * set = ""
         * finalArray= ""
         *
         * 1  finalArray= 1 set = "1"
         * 2  finalArray= 12, set = "12"
         * 3  finalArray = 123 set = "123"
         * 3  finalArray = 123 set = "123"
         * 5  finalArray = 1235 set = "1235"
         */
        print(removeDuplicates(new int[]{1,1,1,1,1})); //1
//        print(removeDuplicates(new int[]{1,2,3,5,5})); //1, 2, 3, 5, 0


    }

    private static void print(int[] ints) {
        System.out.println("========================");
        for(int num: ints) {
            System.out.println(num);
        }
        System.out.println("========================");

    }

    public static int[] removeDuplicates(int[] nums){
        int[] finalArray = new int[nums.length];

        int firstPointer = 0;
        finalArray[firstPointer] = nums[0];

        for(int i =1 ;i<nums.length -1; i++){
            if(nums[firstPointer] == nums[i]){
                //first pointer stay
            }else {
                firstPointer =  ++firstPointer;
                finalArray[firstPointer] = nums[i];
            }
        }

        System.out.println("final Count>"+(firstPointer+1));
        return finalArray;

    }



}
