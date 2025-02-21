import java.util.HashSet;

public class unique_binary_string {

    private static String res = "";
    public static void main(String[] args) {
        String[] array = new String[]{"01","10"};
        System.out.println(function1(array));
    }

    public static String function1(String[] array){
        HashSet<String> set = new HashSet<>();
        for(String str : array){
            set.add(str);
        }

        function2(set,"",array.length);
        return res;
    }

    public static boolean function2(HashSet<String> set, String curr, int len){

        if(curr.length() == len){
            if(!set.contains(curr)){
                res = curr;
                return true;
            }
        }
        if(function2(set, curr + "0", len)){
            return true;
        }

        if(function2(set, curr + "1", len)){
            return true;
        }

        return false;
    }
}
