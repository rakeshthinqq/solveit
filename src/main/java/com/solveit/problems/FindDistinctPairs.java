package com.solveit.problems;

import java.util.HashMap;
import java.util.Map;

public class FindDistinctPairs {
    public static void main(String[] arg){
        System.out.println(numberOfPairs(new int[]{6,1,3,46,1,3,9}, 47));
    }

    static int numberOfPairs(int[] a, long k) {
        int count = 0;
        if(a==null){
            return 0;
        }
        Map<Integer,Long> rem = new HashMap<Integer, Long>();

        int i = 0;
        for(int val: a){
            long remVal = k - val;
            if(rem.containsValue(new Long(val))){
                count = count + 1;
            }else {
                rem.put(i,remVal);
            }
            i = i+2;;
        }
        return count;
    }
}
