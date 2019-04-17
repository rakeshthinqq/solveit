package com.solveit.problems.maps;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class WordCount {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {
// Mmm...mmm...decisions...decisions
            char[] chars = inputString.toCharArray();

            StringBuilder wordBuffer = new StringBuilder();
            for(char ch: chars) {
                System.out.println(wordBuffer.toString());
                if(Character.isLetter(ch) || ch == '\''){
                    wordBuffer.append(ch);
                } else if(wordBuffer.length() > 0 && ch == '-') {
                    wordBuffer.append(ch);
                } else if(wordBuffer.length() > 0) {
                    int count = checkContains(wordBuffer.toString());
                    if (count!= 0) {
                            wordsToCounts.put(wordBuffer.toString(), ++count);
                        } else {
                            wordsToCounts.put(wordBuffer.toString(), 1);
                        }
                        wordBuffer = new StringBuilder();
                    }
            }

            if(wordBuffer.length() > 0) {
                int count = checkContains(wordBuffer.toString());
                if (count!= 0) {
                    wordsToCounts.put(wordBuffer.toString(), ++count);
                } else {
                    wordsToCounts.put(wordBuffer.toString(), 1);
                }
            }
        }

        private int checkContains(String wordBuffer) {
            int retKey =  wordsToCounts.get(wordBuffer);
            if(retKey == 0) {
                retKey = wordsToCounts.get(wordBuffer.toLowerCase());
            }

            if(retKey == 0) {
               retKey = wordsToCounts.get(wordBuffer.toUpperCase());

            }

            if(retKey == 0) {
                retKey = wordsToCounts.get(wordBuffer.substring(0,1).toUpperCase()
                        + wordBuffer.substring(1) );
            }

            return  retKey;

        }




        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }


    /***
     *
     *
     *
     *
     * 1 buf = M
     * 2 buf = Mm
     * 3 buf = Mmm
     * 4 count: {mmm:1, }
     * 5 ...
     * ...
     * 8 buf= m
     * 9 buf = mm
     * 10 buf =mmm
     * 11 count: {mmm:2, }
     *
     */















    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2);
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("mmm", 2);
            put("decisions", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(WordCount.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}