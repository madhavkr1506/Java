public class maximum_nesting_depth_of_parentheses {
    public static void main(String[] args) {
        String str1 = "(1+(2*3)+((8)/4))+1";
        System.out.println(function1(str1));
    }

    public static int function1(String str1){
        int result = 0;
        int count = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) == '('){
                count++;
                result = Math.max(result, count);
            }else if(str1.charAt(i) == ')'){
                count--;
            }
        }

        return result;
    }
}
