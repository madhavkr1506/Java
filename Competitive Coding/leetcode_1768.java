public class leetcode_1768 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        String newStr = newStringAfterMerging(word1, word2);
        System.out.println("New String: " + newStr);

    }

    public static String newStringAfterMerging(String word1, String word2){
        StringBuilder newStr = new StringBuilder();
        int i=0;
        while(i < word1.length() || i < word2.length()){
            if(i < word1.length()){
                newStr.append(word1.charAt(i));
            }
            if(i < word2.length()){
                newStr.append(word2.charAt(i));
            }
            i++;
        }
        return newStr.toString();
    }
}
