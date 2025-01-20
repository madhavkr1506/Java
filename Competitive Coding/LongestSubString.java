import java.util.*;

public class LongestSubString {
    public static int longestsubstring(String s){
        HashMap<Character, Integer> Map = new HashMap<>();
        int longest = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            if(Map.containsKey(currChar)){
                start = Math.max(start, Map.get(currChar) + 1);
            }
            Map.put(currChar, i);
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("LongestSubstring without repetition : " + longestsubstring(str));
    }
}
