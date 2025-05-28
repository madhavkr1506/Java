public class leetcode_785 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.err.println("Check Bipartite: " + isBipartite(graph));

    }

    public static boolean isBipartite(int[][] graph) {
        int number_of_nodes = graph.length;
        int[] visit_state = new int[number_of_nodes];
        for(int i=0;i<graph.length;i++){
            if(visit_state[i] == 0){
                if(!dfs_call(graph, visit_state, i, 1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs_call(int graph[][], int[] visit_state, int current_node, int color){
        if(visit_state[current_node] != 0){
            if(visit_state[current_node] != color){
                return false;
            }else{
                return true;
            }
        }
        visit_state[current_node] = color;
        for (int i=0;i<graph[current_node].length;i++){
            int neighbor = graph[current_node][i];
            if(visit_state[neighbor] == 0){
                if(!dfs_call(graph, visit_state, neighbor, -color)){
                    return false;
                }
            }
            else if (visit_state[neighbor] == color) {
                return false;
            }
        }

        
        return true;

    }
}
