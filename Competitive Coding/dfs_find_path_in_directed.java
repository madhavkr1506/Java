import java.util.*;

public class dfs_find_path_in_directed {

    public static void print_all_possible_path_in_directed_graph(int[][] matrix, boolean[] visited, int start, int destination, ArrayList<Integer> path){
        path.add(start);
        visited[start] = true;

        if(start == destination){
            System.out.println("Path: " + path);
        }
        else{
            for(int i=0;i<matrix.length;i++){
                if(matrix[start][i] == 1 && !visited[i]){
                    print_all_possible_path_in_directed_graph(matrix, visited, i, destination, path);
                }
            }
        }

        path.remove(path.size() - 1);
        visited[start] = false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number of vertices you want: ");
        int vertices = sc.nextInt();
        System.out.print("Input number of edges you want: ");
        int edges = sc.nextInt();

        int[][] matrix = new int[vertices][vertices];
        boolean[] visited = new boolean[vertices];

        for(int i=0;i<edges;i++){
            System.out.print("Input source: ");
            int source = sc.nextInt();
            System.out.print("Input destination: ");
            int destination = sc.nextInt();

            matrix[source][destination] = 1;
        }

        System.out.print("Start vertex: ");
        int start = sc.nextInt();
        System.out.print("Destination vertex: ");
        int destination = sc.nextInt();

        ArrayList<Integer> path = new ArrayList<>();

        System.out.println("Path Printing: ");
        print_all_possible_path_in_directed_graph(matrix, visited, start, destination, path);
        

        sc.close();
    }
}
