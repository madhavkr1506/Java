public class _prefixcommonarray {
    public static void main(String[] args) {
        int array1[] = new int[]{1,3,2,4};
        int array2[] = new int[]{3,1,2,4};
        int[] result = new int[array1.length];
        result = findprefixcommon(array1, array2);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }


    }

    public static int[] findprefixcommon(int[] array1,int[] array2){
        int[] result = new int[array1.length];
        int[] frequencyarray = new int[array1.length + 1];

        int count = 0;
        for(int i=0;i<array1.length;i++){
            frequencyarray[array1[i]]++;
            if(frequencyarray[array1[i]] == 2){
                count++;
            }
            
            frequencyarray[array2[i]]++;
            if(frequencyarray[array2[i]] == 2){
                count++;
            }
            result[i] = count;

        }
        return result;
    }
}
