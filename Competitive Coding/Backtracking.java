public class Backtracking {

    public static void AllPossibleArrangement(String str, String perm, int index){
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String newstr = str.substring(0,i)+str.substring(i+1);
            AllPossibleArrangement(newstr, perm+ch, index+1);
        }

    }
    public static void main(String[] args) {
        System.out.println("N Queen Problem");
        String str = "ABC";
        AllPossibleArrangement(str, "", 0);
        
    }
}



// time complexity = O(n * n!)
