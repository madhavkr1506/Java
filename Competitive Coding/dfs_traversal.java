import java.util.Scanner;

public class dfs_traversal {

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void depth_first_search(int[][] matrix, boolean[] visited, int vertex){
        System.out.print(vertex + " ");
        visited[vertex] = true;
        for(int i=0;i<matrix.length;i++){
            if(matrix[vertex][i] == 1 && !visited[i]){
                depth_first_search(matrix, visited, i);
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertext: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        int[][] matrix = new int[vertices][vertices];
        boolean[] visited = new boolean[vertices];

        for(int i=0;i<edges;i++){
            System.out.print("Enter source: ");
            int source = sc.nextInt();
            System.out.print("Enter destination: ");
            int destination = sc.nextInt();

            matrix[source][destination] = 1;
            matrix[destination][source] = 1;

        }

        System.out.print("DFS Traversal: ");
        depth_first_search(matrix, visited, 0);
        System.out.println("\nMatrix Display: ");

        printMatrix(matrix);

        sc.close();
        
    }
}