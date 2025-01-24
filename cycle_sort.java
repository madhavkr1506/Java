public class cycle_sort {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,4,5};

        function1(array);


        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }

    }

    public static void function1(int[] array){

        int n = array.length;
        for(int i=0;i<n-1;i++){
            int element = array[i];

            int position = i;

            for(int j=i+1;j<n;j++){
                if(array[j] < element){
                    position++;
                }

            }
            if(position == i){
                continue;
            }
            while (element == array[position]) {
                position++;
            }

            if(position != i){
                int temp = element;
                element = array[position];
                array[position] = temp;
            }

            while (position != i) {
                position = i;
                for(int k=i+1;k<n;k++){
                    if(array[k] < element){
                        position++;
                    }
                }
                while (element == array[position]) {
                    position++;
                }

                if(element != array[position]){
                    int temp = element;
                    element = array[position];
                    array[position] = temp;
                }

            }
        }
        
    }

    
}
