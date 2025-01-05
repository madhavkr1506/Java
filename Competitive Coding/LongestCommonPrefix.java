public class LongestCommonPrefix {
    public static String lcp(String[] strs){
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        // String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(lcp(strs1));
        // System.out.println(lcp(strs2));

    }
}
