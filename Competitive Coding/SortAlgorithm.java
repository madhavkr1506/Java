public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,1,2,3,4,7,6,4,8,9};
        // bubbleSort(array);
        // insertionSort(array);
        // selectionSort(array);
        quickSort(array, 0, array.length - 1);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void bubbleSort(int[] array){
        int n = array.length;
        for(int i=0;i<n-1;i++){
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
                
            }
            if(!swapped){
                break;
            }
        }
    }


    public static void insertionSort(int[] array){
        int n = array.length;
        for(int i=1;i<n;i++){
            int key = array[i];
            int j=i-1;
            while (j >= 0 && array[j] < key) {
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;
        }
    }
    public static void selectionSort(int[] array){
        int n=array.length;
        for(int i=0;i<n-1;i++){
            int min_inx = i;
            for(int j=i+1;j<n;j++){
                if(array[j] < array[min_inx]){
                    min_inx = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_inx];
            array[min_inx] = temp;

        }
    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for(int j=low;j<=high-1;j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;

    }

    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pt = partition(array, low, high);
            quickSort(array, low, pt-1);
            quickSort(array, pt+1, high);
        }
    }


    
}
