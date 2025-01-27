import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class LRU_Cache {

    private LinkedList<Integer> deque;
    private Map<Integer, ListIterator<Integer>> map;
    private int capacity;

    public LRU_Cache(int capacity){
        this.capacity = capacity;
        this.deque = new LinkedList<>();
        this.map = new HashMap<>();
    }

    @SuppressWarnings("unlikely-arg-type")
    public void refer(int x){
        if(!map.containsKey(x)){
            if(deque.size() == capacity){
                int last = deque.removeLast();
                map.remove(last);
            }            
        }
        else{
            deque.remove(map.get(x));
        }

        deque.addFirst(x);
        map.put(x, deque.listIterator(0));

    }

    public void display(){
        for(int key : deque){
            System.out.print(key + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);

        cache.display();
    }
}
