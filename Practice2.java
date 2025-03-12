public class Practice2 {
    public static void main(String[] args) {
        String str = "abc";
        findSubString(str);

    }
    // public static void findSubString(String str){
    //     int n = str.length();
    //     int count = 0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             String newStr = str.substring(i, j+1);
    //             if(newStr.contains("a") && newStr.contains("b") && newStr.contains("c")){
    //                 count++;
    //             }
    //         }
    //     }

    //     System.out.println(count);
    // }
    public static void findSubString(String str){
        int n = str.length();
        int left = 0;
        int count = 0;
        int[] freq = new int[3];
        for(int right=0;right<n;right++){
            freq[str.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right;
                freq[str.charAt(left) - 'a']--;
                left++;
            }
        }

        System.out.println(count);
    }
}
