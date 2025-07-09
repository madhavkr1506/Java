import java.util.Arrays;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet","code"};
        Boolean[] memo = new Boolean[s.length()];
        System.out.println(function1(0, s, wordDict, memo));
    }

    public static boolean function1(int index,String str, String[] dict, Boolean[] memo){
        try{
            int n = str.length();
            if (index == n){
                return true;
            }
            if (memo[index] != null){
                return memo[index];
            }
            String prefix = "";
            for(int i=index;i<n;i++){
                prefix += str.charAt(i);
                if(Arrays.asList(dict).contains(prefix) && function1(i + 1,str, dict, memo)){
                    memo[index] = true;
                    return true;
                }
            }
            memo[index] = false;
            return false;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}
