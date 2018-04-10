package com.solveit.problems;

import java.io.*;

/**
 * input:
 * abc torwee
 * ttr abc sdd
 * dds    dd dd
 *
 * output:
 * abc
 *
 *
 */
public class MaxOccuringWordInFile {
    public static void main(String[] args) {
        System.out.println(findMaXOccuringWord("/tmp/sample.txt"));
    }

    private static String findMaXOccuringWord(String fileName) {
        String maxOccWord = "";
        File file = new File(fileName);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            try {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    System.out.println(line);
                }
            } catch (IOException e) {


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return maxOccWord;
    }

}
