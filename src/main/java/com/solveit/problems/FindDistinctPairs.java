package com.solveit.problems;

import java.util.HashMap;
import java.util.Map;

public class FindDistinctPairs {
    public static void main(String[] arg){
        System.out.println(numberOfPairs(new int[]{6,1,3,46,1,3,9}, 47));
    }

    static int numberOfPairs(int[] intArray, long result) {
       Map<Integer, Integer> mp = new HashMap<>();

       int count = 0;
       for(int number : intArray) {
           int rem = (int) (result - number);
           System.out.println(mp);
           if(mp.containsKey(number) && mp.get(number) == null && !mp.containsValue(rem)) {
               count = ++count;
               mp.put(number, rem);
           } else {
               if(!mp.containsKey(rem)  && !mp.containsValue(rem)) {
                   mp.put(rem, null);
               }
           }
       }
        
       return count;
    }
}
