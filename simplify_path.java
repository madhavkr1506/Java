import java.util.Stack;

public class simplify_path {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(function1(path));
        
    }

    public static String function1(String path){
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String comp : components){
            if(comp.equals(".") || comp.equals("")){
                continue;
            }
            if(comp.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(comp);
            }
        }

        StringBuilder newStringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            newStringBuilder.insert(0, "/" + stack.pop());
        }
        return newStringBuilder.length() == 0 ? "/" : newStringBuilder.toString();
    }
}
