import java.util.ArrayList;

public class spiral_rotation {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> arraylist = new ArrayList<>();

        System.out.println("Matrix");
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Spiral Movement: " + spiralMove(array));
    }

    public static ArrayList<Integer> spiralMove(int[][] mat){
        ArrayList<Integer> arraylist = new ArrayList<>();
        int left = 0;
        int right = mat[0].length - 1;
        int top = 0;
        int bottom = mat.length - 1;

        while(left <= right && top <= bottom){
            for(int i=left;i<=right;i++){
                arraylist.add(mat[left][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                arraylist.add(mat[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i=right;i>=left;i--){
                    arraylist.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    arraylist.add(mat[i][left]);
                }
                left++;
            }
        }

        return arraylist;
    }
}
