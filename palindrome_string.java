public class palindrome_string {
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        System.out.println(function1(str1));
        
    }
    public static boolean function1(String str1){
        str1 = str1.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left = 0;
        int right = str1.length() - 1;

        while (left <= right) {
            if(str1.charAt(left) == str1.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        
        return true;
    }
}
