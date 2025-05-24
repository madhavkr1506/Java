import java.util.ArrayList;
import java.util.List;

public class leetcode_2942 {
    public static void main(String[] args) {
        String[] words = new String[]{"leet","code"};
        char x = 'e';
        System.err.println(findWordsContaining(words, x));
    }
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list1 = new ArrayList<>();
        int index = 0;
        for (String str : words){
            if(str.contains(x+"")){
                list1.add(index);
            }
            index++;
        }
        return list1;
    }
}
