import java.util.ArrayList;

public class course_schedule {

    public static void main(String[] args) {
        int[][] array1 = new int[][]{{1,2},{1,0},{2,0},{2,3}};
        int[][] array2 = new int[][]{{1,3},{1,0},{2,1},{2,3}};

        ArrayList<Boolean> list = function1(4, array1, array2);

        for(boolean i : list){
            System.out.print(i + " ");
        }

    }


    public static ArrayList<Boolean> function1(int number_of_course, int[][] array1, int[][] array2){
        int[][] graph = new int[number_of_course][number_of_course];

        ArrayList<Boolean> list = new ArrayList<>(number_of_course);
        for(int i=0;i<array1.length;i++){
            graph[array1[i][0]][array1[i][1]] = 1;
        }

        for(int i=0;i<array2.length;i++){
            list.add(dfs(array2[i][0], array2[i][1], graph, new boolean[number_of_course]));
        }

        return list;

    }

    public static boolean dfs(int u, int v, int[][] graph, boolean[] visited){
        if(u == v){
            return true;
        }
        visited[u] = true;

        for(int i=0;i<graph.length;i++){
            if(graph[u][i] == 1 && !visited[i]){
                if(dfs(i, v, graph, visited)){
                    return true;
                }
            }
        }

        return false;
    }
}