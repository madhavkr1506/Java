import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topological_sort {
    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid = new int[][] { { 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 0, 1, 1, 0, 0, 0 } };

        List<Integer> topoSort = topologicalSort(grid);
        System.out.println("Topological Sort: " + topoSort);
    }

    public static List<Integer> topologicalSort(int[][] grid) {
        int V = grid.length;
        List<Integer> topoSort = new ArrayList<>();

        int[] indegree = new int[V];

        for (int row = 0; row < V; row++) {
            for (int col = 0; col < V; col++) {
                if (grid[row][col] == 1) {
                    indegree[col]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            topoSort.add(currNode);

            for (int i = 0; i < V; i++) {
                if (grid[currNode][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }

            }
        }

        return topoSort;

    }
}
