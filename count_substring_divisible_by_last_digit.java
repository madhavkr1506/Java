public class count_substring_divisible_by_last_digit {
    public static void main(String[] args) {
        String str = "12936";

        function1(str);
    }

    // I have to create a function which basically make substring and check whether its last digit is divisible by substring or not. and, there is a count variable, if substring is divisible then we have to increment count variable.
    public static void function1(String str){

        int totalSubarray = str.length() * (str.length() + 1) / 2;
        int count = 0;
        
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String newstr = str.substring(i, j+1);
                char lastChar = newstr.charAt(newstr.length() - 1);
                int lastDigit = lastChar - '0';
                if(lastDigit == 0){
                    continue;
                }else{
                    int num = Integer.parseInt(newstr);
                    if(num % lastDigit == 0){
                        count++;
                    }
                }
                newstr = "";
            }
            
        }

        System.out.println("count: " + (totalSubarray - count));
    }
}
