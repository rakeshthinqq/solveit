import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Find longest substring without repeating characters.

"ABDEFGABEF"  > ABDEFG

"helloworld" > hel, low, ow,
        world

 heleoweorld
 */
public class LongestSubString {
    public static void main(String[] arg){
      // store the substring
      // store each char

        System.out.println(findLongestSubString("helloworld"));
        /**
         *
         * subString = hel
         * longestSubstring = hel
         * subString = low
         * subString = 0
         *
         *`
         *
         */
        System.out.println(findLongestSubString("ABDEFGABEF"));
        System.out.println(findLongestSubString("abcabcbb"));
        System.out.println(findLongestSubString("bbbbb"));
        System.out.println(findLongestSubString("pwwkew"));




    }

    private static String findLongestSubString(String original){


        String longestSubstring = "";

        StringBuffer latestSubString = new StringBuffer();
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();

        for(int i=0; i < original.length(); i++){
          char ch =   original.charAt(i);
          if(latestSubString.toString().contains(String.valueOf(ch))){
              if(longestSubstring.length() < latestSubString.length()) {
                  longestSubstring = latestSubString.toString();
              }
              latestSubString.delete(0,latestSubString.length());

              int lastOccuredIndex = indexMap.get(ch);
              latestSubString.append(original.substring(lastOccuredIndex+1, i+1));
          } else {
              latestSubString.append(ch);
          }

            indexMap.put(ch, i);
        }

        if(longestSubstring.length() < latestSubString.length()) {
            longestSubstring = latestSubString.toString();
        }

        return longestSubstring;
    }
}
