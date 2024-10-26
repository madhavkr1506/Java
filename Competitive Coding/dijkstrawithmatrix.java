import java.util.ArrayList;
import java.util.Collections;

public class dijkstrawithmatrix {

    static class Node{
        int source;
        int destination;
        int weight;
        Node(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public static void createGraph(ArrayList<Node>[] graph){
            int vertex_count = graph.length;
            for(int i=0;i<vertex_count;i++){
                graph[i] = new ArrayList<>();
            }

            graph[0].add(new Node(0, 1, 2));
            graph[0].add(new Node(0, 2, 4));
            graph[1].add(new Node(1, 2, 1));
            graph[1].add(new Node(1, 3, 7));
            graph[2].add(new Node(2, 4, 3));
            graph[3].add(new Node(3, 4, 2));

        }

        public static ArrayList<Integer> find_shortest_path_from_source_to_all_node(ArrayList<Node>[] graph, int source){
            ArrayList<Integer> path = new ArrayList<>(Collections.nCopies(graph.length, Integer.MAX_VALUE));
            ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(graph.length, false));
            
            path.set(source, 0);

            for(int i=0;i<graph.length-1;i++){
                int u=find_min_distance_node(visited, path);
                if(u == -1){
                    break;
                }
                visited.set(u,true);

                for(Node neighbour_node : graph[u]){
                    int v = neighbour_node.destination;
                    if(!visited.get(v) && path.get(u) != Integer.MAX_VALUE && path.get(u) + neighbour_node.weight < path.get(v)){
                        path.set(v, path.get(u) + neighbour_node.weight);
                    }
                }
            }

            return path;
        }

        public static int find_min_distance_node(ArrayList<Boolean> visited, ArrayList<Integer> path){
            int min_distance = Integer.MAX_VALUE;
            int min_index = -1;

            for(int i=0;i<visited.size();i++){
                if(!visited.get(i) && path.get(i) < min_distance){
                    min_distance = path.get(i);
                    min_index = i;
                }
            }
            return min_index;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList<Node>[] graph = new ArrayList[5];
        Node.createGraph(graph);
        ArrayList<Integer> shortestPath = Node.find_shortest_path_from_source_to_all_node(graph, 0);

        System.out.println("Shortest Path: " + shortestPath);

    }
}