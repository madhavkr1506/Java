import java.util.ArrayList;

public class using_dfs_to_find_shortest_path_between_to_nodes {

    static class Node{
        int source;
        int destination;
        int weight;
        Node(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public static void creteGraph(ArrayList<Node>[] graph){
            int vertex_count = graph.length;
            for(int i=0;i<vertex_count;i++){
                graph[i] = new ArrayList<>();
            }

            graph[0].add(new Node(0,1,2));
            graph[0].add(new Node(0,2,1));
            graph[1].add(new Node(1,3,3));
            graph[2].add(new Node(2,3,1));
            graph[3].add(new Node(3,4,1));
        }

        public static void dfs_shortest_path_between_nodes(ArrayList<Node>[] graph, boolean[] visited, int source, int destination,ArrayList<Integer> path, int currentWeight,int[] min_weight, ArrayList<Integer> shortestPath){
            path.add(source);
            visited[source] = true;

            if(source == destination){
                if(currentWeight < min_weight[0]){
                    min_weight[0] = currentWeight;
                    shortestPath.clear();
                    shortestPath.addAll(path);

                    
                }
            }

            for(int i=0;i<graph[source].size();i++){
                Node temp_ = graph[source].get(i);
                if(visited[temp_.destination] == false){
                    dfs_shortest_path_between_nodes(graph, visited, temp_.destination, destination, path, currentWeight + temp_.weight, min_weight, shortestPath);
                    
                }
            }

            path.remove(path.size() - 1);
            visited[source] = false;
            
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Node>[] graph = new ArrayList[5];
        Node.creteGraph(graph);

        boolean[] visited = new boolean[5];
        int[] min_weight = {Integer.MAX_VALUE};
        ArrayList<Integer> shortestPath = new ArrayList<>();
        Node.dfs_shortest_path_between_nodes(graph, visited, 0, 4, new ArrayList<Integer>(),0,min_weight,shortestPath);

        

        System.out.println("Shortest_path: " + shortestPath);
        System.out.println("Minimum Cost: " + min_weight[0]);

    }
}
