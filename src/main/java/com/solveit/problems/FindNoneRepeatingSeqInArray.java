package com.solveit.problems;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FindNoneRepeatingSeqInArray {
        public static void main(String[] args) {
            System.out.println(findNonRepeatSubArray(new int[]{1,2,1,3}));
            System.out.println(findNonRepeatSubArray(new int[]{1,2,1,3,3}));
            System.out.println(findNonRepeatSubArray(new int[]{1,1,1,1,2}));
            System.out.println(findNonRepeatSubArray(new int[]{1,2,1,1,1,1,1}));
            System.out.println(findNonRepeatSubArray(new int[]{1,2,1,2,1}));
            System.out.println(findNonRepeatSubArray(new int[]{1,2,1,3,3,3,3,4,4}));
            System.out.println(findNonRepeatSubArray(new int[]{1,1,1,1,1}));
            System.out.println(findNonRepeatSubArray(new int[]{}));


        }

        public static Set<Integer> findNonRepeatSubArray(int[] arr) {

            int i=0;
            Set<Integer> set = new HashSet<Integer>();
            Map<Integer,Integer> inMap = new LinkedHashMap<Integer,Integer>();
            while(true) {
                if(i >= arr.length){
                    break;
                }
                int el = arr[i];
                if(inMap.containsKey(el)) {
                    int index = inMap.get(el);
                    i = index;
                    if(inMap.size() >= set.size() ){
                        set = inMap.keySet();
                    }
                    inMap = new LinkedHashMap<Integer,Integer>();
                }else{
                    inMap.put(el, i);
                }

                i++;
            }
            if(set.size() > inMap.size()){ return set;}
            else {return inMap.keySet();}
        }
}
