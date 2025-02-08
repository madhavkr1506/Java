import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {
    static class Pair{
        int vertex;
        int distance;

        Pair(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void function1(List<List<Pair>> graph, int source, int nodes){
        int[] distance = new int[nodes];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        queue.add(new Pair(source, 0));

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            int u = currPair.vertex;
            
            for(Pair neighbour : graph.get(u)){
                int v = neighbour.vertex;
                int weight = neighbour.distance;

                if(distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                    queue.add(new Pair(v, distance[v]));
                }

            }


        }

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < nodes; i++) {
            System.out.println("To " + i + " -> " + (distance[i] == Integer.MAX_VALUE ? "∞" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int nodes = 5;
        List<List<Pair>> graph = new ArrayList<>(nodes);
        for(int i=0;i<nodes;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 10));
        graph.get(0).add(new Pair(2, 3));
        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(3, 2));
        graph.get(2).add(new Pair(1, 4));
        graph.get(2).add(new Pair(3, 8));
        graph.get(2).add(new Pair(4, 2));
        graph.get(3).add(new Pair(4, 7));
        graph.get(4).add(new Pair(3, 9));


        function1(graph, 0, nodes);


    }
}
