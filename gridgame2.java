public class gridgame2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(findelement(matrix, target));
        

    }

    public static boolean findelement(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int xcor = (mid / col);
            int ycor = (mid % col);
            if(matrix[xcor][ycor] == target){
                return true;
            }else if(matrix[xcor][ycor] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}