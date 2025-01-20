import java.util.*;

public class bfs_traversal {

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void breadth_first_traversal(int[][] matrix, boolean[] visited, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while(!queue.isEmpty()){
            int vertex_ = queue.poll();
            System.out.print(vertex_ + " ");
            visited[vertex_] = true;

            for(int i=0;i<matrix.length;i++){
                if(matrix[vertex_][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);

                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
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

        System.out.print("BFS Traversal: ");
        breadth_first_traversal(matrix, visited, 0);
        System.out.println("\nMatrix:");
        printMatrix(matrix);

    }
}
