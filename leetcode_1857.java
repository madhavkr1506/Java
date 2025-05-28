import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1857 {
    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        System.out.println(largestPathValue(colors, edges));

    }

    public static int largestPathValue(String colors, int[][] edges){
        
        int n = colors.length();
        List<List<Integer>> graph = buildGraph(n, edges);

        int[] indegree = new int[n];

        for(int[] edge:  edges){
            indegree[edge[1]]++;
        }

        List<Integer> topoOrder = getTopologicalOrder(graph, indegree.clone());
        if (topoOrder == null){
            return -1;
        }

        int[][] colorCount = new int[n][26];
        int max_color_value = 0;
        for(int node : topoOrder){
            int color_index = colors.charAt(node) - 'a';
            colorCount[node][color_index]++;
            for(int neighbor: graph.get(node)){
                for(int c=0;c<26;c++){
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }
            }

            max_color_value = Math.max(max_color_value, colorCount[node][color_index]);

        }

        return max_color_value;


    }

    public static List<List<Integer>> buildGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);

        }
        return graph;
    }

    private static List<Integer> getTopologicalOrder(List<List<Integer>> graph, int[] indegree){
        int n = graph.size();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list1.add(node);

            for(int neighbor : graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        if(list1.size() < n){
            return null;
        }

        return list1;
    }
}
