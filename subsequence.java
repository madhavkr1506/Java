import java.util.ArrayList;
import java.util.List;

public class subsequence {
    public static void main(String[] args) {
        String str = "1010";
        List<String> result = findSubSequence(str);
        System.out.println(result);
    }

    public static List<String> findSubSequence(String str){
        int index = 0;
        String temp = new String();
        List<String> sublist = new ArrayList<>();
        subSeqUtil(str,index,temp,sublist);
        return sublist;
    }

    public static void subSeqUtil(String str, int index, String temp, List<String> sublist){
        if(index == str.length()){
            if(temp.length() > 0){
                // System.out.println(temp);
                sublist.add(temp);
                
            }
            return;
            
        }
        subSeqUtil(str, index+1, temp+str.charAt(index), sublist);
        subSeqUtil(str, index+1, temp, sublist);
    }

}
