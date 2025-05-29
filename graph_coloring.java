import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph_coloring {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2}};
        int number_of_nodes = 3;
        boolean result = color_graph(edges, number_of_nodes);
        System.out.println("Can be 2-colored? " + result);

    }

    public static boolean color_graph(int[][] edges, int number_of_nodes){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<number_of_nodes;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }

        int[] colors = new int[number_of_nodes];
        for(int i=0;i<number_of_nodes;i++){
            if(colors[i] == 0){
                if(!bfs_coloring(graph, i, colors)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bfs_coloring(List<List<Integer>> graph, int current_vertex, int[] colors){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current_vertex);
        colors[current_vertex] = 1;

        while (!queue.isEmpty()) {
            current_vertex = queue.poll();
            for(int neighbor : graph.get(current_vertex)){
                if(colors[neighbor] == 0){
                    colors[neighbor] = (colors[current_vertex] == 1) ? 2 : 1;
                    queue.offer(neighbor);
                }else if(colors[neighbor] == colors[current_vertex]){
                    return false;
                }
            }
        }
        return true;
    }

}
