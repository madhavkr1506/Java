import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class winter_gameid1004 {

    public static void main(String[] args) {
        String str = "aabca";
        int count = uniquepalindromicsubsequence(str);
        System.out.println(count);
        
    }
    public static int uniquepalindromicsubsequence(String str){
        int n = str.length();
        HashMap<Character,int[]> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new int[]{i,i});
            }else{
                map.get(ch)[1] = i;
            }
        }

        for(Map.Entry<Character,int[]> entry : map.entrySet()){
            int[] position = entry.getValue();
            int left = position[0];
            int right = position[1];
            if(right > left){
                Set<Character> set = new HashSet<>();
                for(int i = left + 1;i< right;i++){
                    set.add(str.charAt(i));
                }
                count+=set.size();
            }
        }
        return count;

    }
}