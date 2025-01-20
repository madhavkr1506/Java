public class winter_gameid1002 {
    public static void main(String[] args) {
        String str = "My name is Madhav Kumar  ";
        int laststringlen = findlaststringlen(str);
        System.out.println("Last String length: " + laststringlen);
        
    }
    public static int findlaststringlen(String string){
        int len = 0;
        boolean isSpace = false;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == ' '){
                isSpace = true;
                len = 1;
            }
            else{
                if(isSpace){
                    len = 0;
                    isSpace = false;
                }
                len+=1;
            }
        }
        return len;
    }
}
