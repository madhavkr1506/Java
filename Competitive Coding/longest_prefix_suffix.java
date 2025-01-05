public class longest_prefix_suffix {

    public static int longestPrefixSuffix(String string){
        int n = string.length();
        int[] lps = new int[n];

        int length = 0;
        int i = 1;

        while (i < n) {
            if(string.charAt(i) == string.charAt(length)){
                length++;
                lps[i] = length;
                i++;
                
            }else{
                if(length != 0){
                    length = lps[length - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[n - 1];
    }
    public static void main(String[] args) {
        String string = "abab";
        System.out.println("Longest Prefix and Suffix: " + longestPrefixSuffix(string));
    }
}
