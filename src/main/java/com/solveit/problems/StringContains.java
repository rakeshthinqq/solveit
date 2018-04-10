package com.solveit.problems;

public class StringContains {
    public static void main(String[] arg){
        System.out.println(findContains("ABABC", "ABC"));
        System.out.println(findContains("AAB", "X"));
        System.out.println(findContains("hello world", "world"));
        System.out.println(findContains("aaa ", "a"));
        System.out.println(findContains("ababab", "ab"));
        System.out.println(findContains("ab a ab", "a"));
        System.out.println(findContains("abc", "abc"));
        System.out.println(findContains("bc", "abc"));
        System.out.println(findContains("aaaaaaaaabc", "abc"));
        System.out.println(findContains("aaaaaaaaabc", "aaaaaaaaa"));

        //void second loop by keeping the index of last iteration
    }

    private static boolean findContains(String source, String dest) {
        boolean retVal = false;

        if(source==null || dest == null){
            return retVal;
        }

        char[] aArray = source.toCharArray();
        char[] bArray = dest.toCharArray();

        if(aArray.length == 0 || bArray.length ==0){
            return retVal;
        }

        if(aArray.length < bArray.length){
            return retVal;
        }


        int i = 0;
        while(i < aArray.length) {

            int j =0;
            int k = i;
            while(j < bArray.length) {
                if(aArray[k] == bArray[j]){
                    k++;
                    j++;
                } else {
                    break;
                }
            }

            if(j == bArray.length) {
                retVal = true;
                break;
            }

            i++;

        }

        return retVal;
    }
}
