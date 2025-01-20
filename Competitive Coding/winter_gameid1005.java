import java.util.HashMap;

public class winter_gameid1005 {
    public static void main(String[] args) {
        String string = "geeksforgeeks";
        int maxlen = 0;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<string.length();i++){
            char c = string.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c,i);
            maxlen = Math.max(maxlen, i - start + 1);
        }
        System.out.println("Maximum length of unique character substring: " + maxlen);
    }
}
