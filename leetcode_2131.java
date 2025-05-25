import java.util.HashMap;
public class leetcode_2131 {
    public static void main(String[] args) {
        String[] words = new String[]{"lc","cl","gg"};
        System.err.println(longestPalindrome(words));

    }
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        boolean hasmiddle = false;
        for(String word : map.keySet()){
            String rev = new StringBuilder(word).reverse().toString();
            if(rev.equals(word)){
                int count = map.get(word);
                length += (count / 2) * 4;
                if(count % 2 == 1){
                    hasmiddle = true;
                }
                
            }else if(!word.equals(rev) && map.containsKey(rev)){
                int pairs = Math.min(map.get(word), map.get(rev));
                length += pairs * 4;
                map.put(word, map.get(word) - pairs);
                map.put(rev, map.get(rev) - pairs);
            }
        }
        if(hasmiddle){
            length += 2;
        }

        return length;
    }
}
