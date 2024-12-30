import java.util.Arrays;

public class winter_gameid1001 {

    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,21,22,30};
        int n = array.length;
        int longestseq = findlongestsequence(array, n);
        System.out.println("LongestSequence = " + longestseq);

    }
    public static int findlongestsequence(int[] array, int n){
        Arrays.sort(array);
        int seq = 1;
        int longestseq = seq;
        for(int i=0,j=i+1;i<n-1 && j<n;i++,j++){
            if(array[j] - array[i] == 1){
                seq++;
                longestseq = Math.max(longestseq, seq);
            }
            else{
                seq = 1;
            }

        }
        return longestseq;
    }
}