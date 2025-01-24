import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class safe_states {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(function1(matrix));

    }

    public static List<Integer> function1(int[][] matrix){
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            if(dfs(matrix, map,i)){
                list.add(i);
            }
        }
        return list;   
    }

    public static boolean dfs(int[][] matrix,HashMap<Integer,Boolean> map, int node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        map.put(node, false);
        for(int i : matrix[node]){
            if(!dfs(matrix, map, i)){
                return false;
            }
        }
        map.put(node, true);
        return true;
    }
}
