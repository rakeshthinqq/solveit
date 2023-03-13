
import java.util.*;
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
      List<List<String>> resultLst = new ArrayList<>();
        
      Map<String,List<String>> lookup = new HashMap<>();
        
      for(String str: strs) {
          
          char[] strArray = str.toCharArray();
          java.util.Arrays.sort(strArray);
          String sortedStr = new String(strArray);
          if(lookup.containsKey(sortedStr)) {
             List<String> groupedList =  lookup.get(sortedStr);
             groupedList.add(str);
          } else {
              List<String> newList = new ArrayList<>();
              newList.add(str);
              lookup.put(sortedStr, newList);
          }
      }
        
      for(Map.Entry<String,List<String>> entry: lookup.entrySet()) {
          
          resultLst.add(entry.getValue());
      }
        
      return resultLst;
      
    }
}
