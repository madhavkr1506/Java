import java.util.*;
public class List {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        ArrayList<String> innerList = new ArrayList<>();
        innerList.add("Madhav");
        innerList.add("Krishna");
        innerList.add("Keshav");
        innerList.add("Mahadev");
        innerList.add("Rahul");
        innerList.add("Rohan");

        arrayList.add(0,innerList);

        for(int i=0;i<arrayList.get(0).size();i++){
            System.out.println(arrayList.get(0).get(i));
        }

    }
}