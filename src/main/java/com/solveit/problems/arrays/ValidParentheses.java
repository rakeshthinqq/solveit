/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 
 */


class Solution {
    public boolean isValid(String s) {
        
        char[] chArray = s.toCharArray();
        Stack<Character> stack  = new Stack();
        boolean isValid = true;
        
        for(char ch: chArray) {
            if(isOpen(ch)) {
                stack.push(ch);
            } else if(isClose(ch)) {
                if(!stack.isEmpty() && isPair(stack.pop(),ch )) {
                    continue;
                } else {
                    isValid = false;
                    break;
                }
            } 
        }
        
        if(chArray.length == 1 || !stack.isEmpty()) {
            isValid = false;
        }
        
        return isValid;

    }
    
    public boolean isPair(char first, char sec) {
        if(first == '(' && sec == ')') return true;
        if(first == '{' && sec == '}') return true;
        if(first == '[' && sec == ']') return true;
        return false;
   
    }
    
    public boolean isOpen(char ch) {
        if(ch == '(' || ch == '{' || ch == '[') {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isClose(char ch) {
        if(ch == ')' || ch == '}' || ch == ']') {
            return true;
        } else {
            return false;
        }
    }
}
