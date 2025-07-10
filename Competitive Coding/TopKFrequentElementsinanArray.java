import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementsinanArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        List<Integer> list = function1(arr, k);
        System.out.println(list);
    }

    public static List<Integer> function1(int[] arr, int k){
        try{
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> hmap = new HashMap<>();
            
            for(int i=0;i<arr.length;i++){
                hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            });
            
            for (Map.Entry<Integer, Integer> map : hmap.entrySet()){
                pq.offer(new int[]{map.getValue(), map.getKey()});
                if(pq.size() > k){
                    pq.poll();

                }

            }

            while (!pq.isEmpty()) {
                list.add(pq.poll()[1]);
            }

            Collections.reverse(list);
            return list;

        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
