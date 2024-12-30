import java.util.Arrays;

public class winter_gameid1001 {

    public static void main(String[] args) {
        int[] array = {1,2,0,1};
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
            else if(array[j] == array[i]){
                continue;
            }
            else{
                seq = 1;
            }

        }
        return longestseq;
    }
}