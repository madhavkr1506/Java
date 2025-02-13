import java.util.PriorityQueue;

public class threshold_value2 {
    public static void main(String[] args) {
        int[] array = {2,11,10,1,3};
        int k = 10;
        System.out.println(function1(array, k));
    }

    public static int function1(int[] array, int k){
        if(array.length < 2){
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            if(array[i] < k){
                queue.add(array[i]);
            }
        }

        int operationCount = 0;
        while(queue.size() > 1){
            operationCount++;
            int ele1 = queue.poll();
            int ele2 = queue.poll();
            int result = ele1 * 2 + ele2;
            if(result < k){
                queue.add(result);
            }
            
        }

        if(!queue.isEmpty() && queue.peek() < k) return -1;

        return operationCount;

    }
}
