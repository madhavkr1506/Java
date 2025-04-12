import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1418{
    public static void main(String[] args) {
        
        List<List<String>> orders = new ArrayList<>();
        orders.add(List.of("David","3","Ceviche"));
        orders.add(List.of("Corina","10","Beef Burrito"));
        orders.add(List.of("David","3","Fried Chicken"));
        orders.add(List.of("Carla","5","Water"));
        orders.add(List.of("Carla","5","Ceviche"));
        orders.add(List.of("Rous","3","Ceviche"));

        HashMap<Integer,HashMap<String, Integer>> foodMap = new HashMap<>();
        for(List<String> item : orders){
            int tableNumber = Integer.parseInt((String) item.get(1));
            String foodItem = (String) item.get(2);
            foodMap.putIfAbsent(tableNumber, new HashMap<>());
            HashMap<String, Integer> tableOrder = foodMap.get(tableNumber);
            tableOrder.put(foodItem, tableOrder.getOrDefault(foodItem, 0) + 1);
            
        }


        for(Map.Entry<Integer,HashMap<String, Integer>> element : foodMap.entrySet()){
            Integer tableNo = element.getKey();
            HashMap<String, Integer> element_value = element.getValue();
            System.out.println("Table no " + tableNo + " ordered:");
            for(Map.Entry<String, Integer> element_value_map : element_value.entrySet()){
                System.out.println("Food: " + element_value_map.getKey() + " Count: " + element_value_map.getValue());
            }
        }
    }
}
