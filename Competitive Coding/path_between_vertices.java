import java.util.ArrayList;
import java.util.Scanner;

public class path_between_vertices {

    public static void printAdjacencyMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.printf("%4d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printPath_usingDFS(int[][] matrix, boolean[] visited, int start, int destination, ArrayList<Integer> path){
        path.add(start);
        visited[start] = true;

        if(start == destination){
            System.out.println("Path: " + path);
        }

        for(int i=0;i<matrix.length;i++){
            if(matrix[start][i] == 1 && !visited[i]){
                printPath_usingDFS(matrix, visited, i, destination, path);
            }
        }

        path.remove(path.size() - 1);
        // return false;

        visited[start] = false;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices you want: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges you want: ");
        int edges = sc.nextInt();

        int[][] adjacency_matrix = new int[vertices][vertices];

        for(int i=0;i<edges;i++){
            System.out.print("Enter source: ");
            int source = sc.nextInt();
            System.out.print("Enter destination: ");
            int destination = sc.nextInt();

            adjacency_matrix[source][destination] = 1;
            adjacency_matrix[destination][source] = 1;
        }

        System.out.print("Start vertex: ");
        int start = sc.nextInt();
        System.out.print("Destination vertex: ");
        int destination = sc.nextInt();

        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        // if(printPath_usingDFS(adjacency_matrix, visited, start, destination, path)){
        //     System.out.println("There exists a path between " + start + " and " + destination);
        //     // System.out.println("Printing path: ");
        //     // for(int i=0;i<path.size();i++){
        //     //     System.out.print(path.get(i) + " ");
        //     // }
        // }
        // else{
        //     System.out.println("There is no path between " + start + " and " + destination);
        // }

        System.out.println("There exists a path between " + start + " and " + destination);
        printPath_usingDFS(adjacency_matrix, visited, start, destination, path);

    }
}
