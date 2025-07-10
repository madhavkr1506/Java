import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcdefabcbb";
        System.out.println(function1(str));

    }

    public static int function1(String str){
        try{
            int len = str.length();
            int start = 0;
            int longest = 0;
            // String longestSub = "";
            HashMap<Character, Integer> hmap = new HashMap<>();
            for(int i=0;i<len;i++){
                char c = str.charAt(i);
                if(hmap.containsKey(c)){
                    start = Math.max(start, hmap.get(c) + 1);
                }
                hmap.put(c, i);
                longest = Math.max(longest, i + 1 - start);
            }
            return longest;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
