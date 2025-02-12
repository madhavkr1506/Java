import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class prims_algorithm {

    static class Edge{
        int destination;
        int weight;

        Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int nodes = 5;

        List<List<Edge>> graph = new ArrayList<>(nodes);

        for(int i=0;i<nodes;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 2));
        graph.get(2).add(new Edge(1, 4));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 2));
        graph.get(3).add(new Edge(4, 7));
        graph.get(4).add(new Edge(3, 9));

        function1(graph, 0);


    }

    public static void function1(List<List<Edge>> graph, int start){
  

        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        int[] parents = new int[graph.size()];
        parents[start] = -1;

        boolean[] mstNode = new boolean[graph.size()];

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.destination;
            if(mstNode[vertex]){
                continue;
            }
            mstNode[vertex] = true;

            for(Edge neighbour : graph.get(vertex)){
                int neighbourVertex = neighbour.destination;
                int weight = neighbour.weight;
                if(!mstNode[neighbourVertex] && weight < distance[neighbourVertex]){
                    distance[neighbourVertex] = weight;
                    parents[neighbourVertex] = vertex;
                    queue.add(new Edge(neighbourVertex, weight));
                }
            }

        }
        System.out.println("Edges in MST");
        for (int i = 1; i < graph.size(); i++) {
            System.out.println(parents[i] + " - " + i + " with weight " + distance[i]);
        }
    }
}
