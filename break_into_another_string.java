public class break_into_another_string {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xya";
        System.out.println(function1(s1, s2));
    }

    public static boolean function1(String s1, String s2){
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : s1.toCharArray()){
            freq1[c - 'a']++;
        }
        for(char c : s2.toCharArray()){
            freq2[c - 'a']++;
        }
        return check(freq1,freq2) || check(freq2,freq1); 
    }


    public static boolean check(int[] freq1, int[] freq2){
        int diff = 0;
        for(int i=0;i<26;i++){
            diff += freq1[i];
            if(freq2[i] == 0){
                continue;
            }
            if(diff < freq2[i]){
                return false;
            }
            diff -= freq2[i];
        }

        return true;
    }
}