import java.util.Stack;

public class valid_parentheses {
    public static void main(String[] args) {
        String str = "()[]";
        System.out.println("Answer: " + function1(str));
    }

    public static boolean function1(String str){

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty() || !function2(stack.pop(),c)){
                    return false;
                }
            }
        }

        return true;

    }
    public static boolean function2(char open, char close){
        return open == '(' && close == ')' ||
        open == '[' && close == ']' ||
        open == '{' && close == '}';
    }
}
