package com.solveit.problems.maps;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.*;

public class FlightMovieMapping {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // determine if two movies add up to the flight length

        // initialize a set
        // interat lengths
        //find delta,
        //if exist in result return true and brea
        //if not keep delta in result
        //return false;

        /**  1) 1 2 3 /// 5
         *  Set >> 4 3
         *
         *  2) 3 6 2  // 10
         *  Set >> 7 4 8
         **/

        /**
         *
         *      /**  1) 1 2 3 /// 5
         *  Set >> 1 2
         * */

        Set<Integer> deltaSet = new HashSet<Integer> ();

        boolean canTwoMoviesFillFlight = false;

        for(int length: movieLengths) {
            int delta = flightLength - length;
            if(deltaSet.contains(length)) {
                canTwoMoviesFillFlight = true;
                break;
            } else {
                deltaSet.add(delta);
            }
        }

        return canTwoMoviesFillFlight;
    }


















    // tests

    @Test
    public void shortFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 1);
        assertFalse(result);
    }

    @Test
    public void longFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 6);
        assertTrue(result);
    }

    @Test
    public void onlyOneMovieHalfFlightLenghtTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {3, 8}, 6);
        assertFalse(result);
    }

    @Test
    public void twoMoviesHalfFlightLengthTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {3, 8, 3}, 6);
        assertTrue(result);
    }

    @Test
    public void lotsOfPossiblePairsTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {1, 2, 3, 4, 5, 6}, 7);
        assertTrue(result);
    }

    @Test
    public void notUsingFirstMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {4, 3, 2}, 5);
        assertTrue(result);
    }

    @Test
    public void oneMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {}, 6);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FlightMovieMapping.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
