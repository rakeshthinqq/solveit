package com.solveit.problems.maps;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Palindrome {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome

        // count chars
        // Initialize a map >>  key as char anv calue as count
        // Iterate
        // update count in map

        // middile number = false;
        // isPal = true;

        //iterate hasmap
        //check count
        // if count is a odd number
        // check its 1 && total word count is ODD
        // if if middle is reached return
        //        // else isPal = false

        /***
         * ccc
         * Map (c,1), (i,2), (v,1), (l,1) // isOdd=true
         *
         * */
        int strCount = theString.length();
        if(strCount ==0) {
            return true;
        }
        boolean isOdd = strCount %2 == 0 ? false: true;

        Map<Character, Integer> lookUp = new HashMap<>();

        boolean isAllSame = true;
        char prev = theString.charAt(0);

        for(char ch: theString.toCharArray()) {
            if(lookUp.containsKey(ch)) {
                int count =  lookUp.get(ch);
                lookUp.put(ch, ++count);
            } else {
                lookUp.put(ch, 1);
            }

            if(prev!=ch){
                isAllSame = false;
            }
        }


        boolean isPal = true;

        if(isAllSame) {
            return isPal;
        } else {

            boolean midVisited = false;
            for(Character key: lookUp.keySet()) {
                if(lookUp.get(key) %2 !=0) {
                    if(lookUp.get(key) == 1 && isOdd && !midVisited) {
                        midVisited = true;
                        continue;
                    } else {
                        isPal = false;
                        break;
                    }
                }
            }
        }

        return isPal;
    }



///ccciccc














    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Palindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
