public class winter_gameid1006 {
    public static void main(String[] args) {
        String str = "abc";
        int[][] queries = {{0,1,0},{1,2,1},{0,2,1}};
        String result = shiftingletters(str, queries);
        System.out.println("Result: " + result);

    }
    public static String shiftingletters(String str, int[][] queries){
        String result = "";
        int[] differencearray = new int[str.length() + 1];
        for(int[] array : queries){
            int start = array[0];
            int end = array[1];
            int shift = array[2];
            if(shift == 0){
                differencearray[start] -= 1;
                differencearray[end + 1] += 1;
            }else if(shift == 1){
                differencearray[start] +=1;
                differencearray[end + 1] -=1;
            }
        }

        for(int i=0;i<differencearray.length;i++){
            if(i > 0){
                differencearray[i] = differencearray[i] + differencearray[i-1];
            }
        }

        for(int i=0;i<differencearray.length-1;i++){
            int count = differencearray[i] % 26;
            if(count < 0){
                count += 26;
            }
            result += (char)(((str.charAt(i) - 'a' + count)%26 )+ 'a');
            
        }


        return result;
    }
}
