public class longestsubstringwithkrepeating {

    public static void main(String[] args) {
        String str = "aaabb";
        int k = 3;
        System.out.println("Max length: " + function1(str, k));

    }

    public static int function1(String str,int k){
        int[] freq = new int[26];
        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        int start = 0;
        int maxlen = 0;
        boolean isvalid = true;

        for(int end = 0;end < str.length();end++){
            if(freq[str.charAt(end) - 'a'] > 0 && freq[str.charAt(end) - 'a'] < k){
                String subString = str.substring(start, end);
                maxlen = Math.max(maxlen, function1(subString, k));
                start = end + 1;
                isvalid = false;
            }
        }

        if(isvalid){
            return str.length();
        }else{
            return maxlen = Math.max(maxlen, function1(str.substring(start), k));
        }
    }
}