import java.util.HashSet;
import java.util.Set;

public class leetcode_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s){

        Set<Character> set = new HashSet<>();

        int max_len = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}
