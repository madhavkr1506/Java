import java.util.*;
import java.util.List;

public class Compare2DArray {
    public static void main(String[] args) {
        int[][] array = new int[][]{{12,13},{11,15},{30,35}};

        // Arrays.sort(array, (a,b) -> Integer.compare(b[0], a[0]));

        // for(int i=0;i<array.length;i++){
        //     for(int j=0;j<array[i].length;j++){
        //         System.out.print(array[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // List<int[]> list = Arrays.asList(array);
        // list.sort((a,b) -> Integer.compare(a[0], b[0]));

        // int[][] sortedArray = list.toArray(new int[array.length][]);

        // for(int i=0;i<sortedArray.length;i++){
        //     for(int j=0;j<sortedArray[0].length;j++){
        //         System.out.print(sortedArray[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        

        int[][] sortedArray = Arrays.stream(array).sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);

        for(int i=0;i<sortedArray.length;i++){
            for(int j=0;j<sortedArray[i].length;j++){
                System.out.print(sortedArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}