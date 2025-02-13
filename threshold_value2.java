import java.util.PriorityQueue;

public class threshold_value2 {
    public static void main(String[] args) {
        int[] array = {2,11,10,1,3};
        int k = 10;
        System.out.println(function1(array, k));
    }

    public static int function1(int[] array, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            
            queue.add((int)array[i]);
            
        }

        int operationCount = 0;
        while(!queue.isEmpty()){
            int ele1 = queue.poll();
            if(ele1 >= k){
                break;
            }
            int ele2 = queue.poll();
            queue.add(Math.min(ele1, ele2) * 2 + Math.max(ele1, ele2));
            operationCount++;
            
        }

        return operationCount;

    }
}
