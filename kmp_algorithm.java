import java.util.ArrayList;

public class kmp_algorithm {
    public static void main(String[] args) {
        String text = "aabaacaadaabaaba";
        String pattern = "aaba";

        System.out.println(search(pattern, text));
        
    }

    public static void makeLps(String pattern, int[] lps){
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }


    public static ArrayList<Integer> search(String pattern, String text){
        int n = text.length();
        int  m = pattern.length();

        int[] lps = new int[m];
        
        makeLps(pattern, lps);

        ArrayList<Integer> list = new ArrayList<>();

        int i=0,j=0;

        while (i < n) {
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;

                if(j == m){
                    list.add(i - j);
                    j = lps[j - 1];
                }
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }


        return list;
    }
}
