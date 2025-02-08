import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bellman_ford {
    static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void function1(List<Edge> EdgeList, int source, int nodes){
        int[] distance = new int[nodes];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        for(int i=0;i<nodes - 1;i++){
            for(Edge edge : EdgeList){
                int u = edge.source;
                int weight = edge.weight;
                int v = edge.destination;

                if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                }
            }
        }

        boolean isNegativeCycle = false;

        for(Edge edge : EdgeList){
            int u = edge.source;
            int weight = edge.weight;
            int v = edge.destination;

            if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                isNegativeCycle = true;
            }
        }

        if(isNegativeCycle){
            System.out.println("Graph contains a negative weight cycle!");
            return;
        }

        System.out.println("shortest distance from node " + source + " : ");
        for (int i = 0; i < nodes; i++) {
            System.out.println("To " + i + " -> " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
        }
    }
    public static void main(String[] args) {
        int nodes = 4;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 1, -1));

        function1(edges, 0, nodes);
    }
}
