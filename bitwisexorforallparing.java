public class bitwisexorforallparing {
    public static void main(String[] args) {
        int[] array1 = {2,1,3};
        int[] array2 = {10,2,5,0};

        // int xor = 0;
        // for(int i=0;i<array1.length;i++){
            
        //     for(int j=0;j<array2.length;j++){
        //         xor ^= array1[i] ^ array2[j];
        //     }
            
        // }



        // System.out.println("XOR : " + xor);


        int xor = 0;
        if(array1.length % 2 != 0){
            for(int i : array2){
                xor ^= i;
            }
        }
        if(array2.length % 2 != 0){
            for(int i : array1){
                xor ^= i;
            }
        }

        System.out.println("XOR: " + xor);
    }
}
