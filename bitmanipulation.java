public class bitmanipulation {
    public static void main(String[] args) {
        int num1 = 8;
        int num2 = 21;

        int[] num1array = bitarray(num1);
        int[] num2array = bitarray(num2);

        int set_bit = 0;
        for(int i : num2array){
            if(i == 1){
                set_bit++;
            }
        }

        int[] x = new int[num1array.length];
        for(int i=0;i<num1array.length;i++){
            if(num1array[i] == 1){
                x[i] = 1;
                set_bit--;
            }
        }

        if(set_bit > 0){
            for(int i=x.length-1;i>=0;i--){
                if(set_bit <= 0){
                    break;
                }
                if(x[i] != 1){
                    x[i] = 1;
                    set_bit--;
                }
            }
        }

        int decimalnumber = convertintodecimal(x);
        System.out.println("Decimal Number: " + decimalnumber);



    }

    public static int[] bitarray(int num){
        int[] array = new int[32];
        int index = 0;
        while(num > 0){
            array[index++] = num%2;
            num/=2;
        }

        int[] trimmedArray = new int[index];
        for(int i=0;i<index;i++){
            trimmedArray[i] = array[index-i-1];
        }

        // for(int i=0;i<trimmedArray.length / 2;i++){
        //     int temp = trimmedArray[i];
        //     trimmedArray[i] = trimmedArray[trimmedArray.length - i - 1];
        //     trimmedArray[trimmedArray.length - i - 1] = temp;
        // }

        return trimmedArray;
    }

    public static int convertintodecimal(int[] array){
        int decimalnumber = 0;
        for(int i=0;i<array.length;i++){
            decimalnumber = decimalnumber * 2 + array[i];
        }
        return decimalnumber;
    }
}
