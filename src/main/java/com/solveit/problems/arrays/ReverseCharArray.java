package arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;

public class ReverseCharArray {

    public static void reverse(char[] arrayOfChars) {

        // reverse input array of characters in place
        // 1) if length is 1 return array

        //inititalize S and E

        //iterate wne S < E
        //replace S char with E char

        //================


        if(arrayOfChars.length <2) {
            return;
        }

        int head = 0;
        int tail = arrayOfChars.length -1;

        while(head < tail) {
            char tmp = arrayOfChars[head];
            arrayOfChars[head] = arrayOfChars[tail];
            arrayOfChars[tail] = tmp;
            ++head;
            --tail;
        }

    }


















    // tests

    @Test
    public void emptyStringTest() {
        final char[] actual = "".toCharArray();
        reverse(actual);
        final char[] expected = "".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] actual = "A".toCharArray();
        reverse(actual);
        final char[] expected = "A".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        final char[] expected = "EDCBA".toCharArray();
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseCharArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}