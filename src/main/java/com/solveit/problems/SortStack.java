package com.solveit.problems;

import java.util.Stack;

/**
 *
 *
 * How to sort a Stack using a temporary Stack?
 *
 * s [10, 8, 1]  >> [1 8 10]
 * ====
 * s 10 8
 * t 1
 *====
 * s 10
 * t 1 8
 * ==
 * s []
 * t 1 8 10
 * ==========================
 * s [10, 8, 11]  >> [8 10 11]
 * ===
 * s 10 8
 * t 11
 * ==
 *
 * s 10 11
 * t 8
 * x =
 * ===
 * s 11 8
 * t 10
 * ===
 * s 11 10
 * t 8
 * ==
 * s = []
 * t 8 10 11
 */

public class SortStack {

        public static void main(String[] arg){
            Stack<Integer> s = new Stack<Integer>();
            s.push(10);
            s.push(8);
            s.push(1);
            printStack(s);

            Stack<Integer> sortedStack = sortStack(s);
            printStack(sortedStack);
            //expeccted  1 8 10

            //============== test 2 ==============
            s.clear();
            s.push(10);
            s.push(8);
            s.push(11);
            printStack(s);

            sortedStack = sortStack(s);
            printStack(sortedStack);
            //expected 8 10 11

        }

    private static void printStack(Stack<Integer> s) {
        System.out.println(s);
    }

    public static Stack<Integer>  sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();

        while(!input.isEmpty()) {
            int tmp = input.pop();
            if(tmpStack.isEmpty()){
                tmpStack.push(tmp);
            } else {
                if(tmp < tmpStack.peek()){
                    while (!tmpStack.isEmpty()){
                        input.push(tmpStack.pop());
                    }
                }
                tmpStack.push(tmp);
            }
        }

        return tmpStack;

    }

}
