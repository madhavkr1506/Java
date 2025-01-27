import java.util.ArrayList;

public class find_winner_of_circular_game {
    public static void main(String[] args) {
        int n = 5; int k = 2;

        System.out.println(function1(n, k));
        System.out.println(function2(n, k));



    }

    public static int function1(int n, int k){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=1;i<=n;i++){
            array.add(i);
        }

        int currindex = 0;

        while (array.size() > 1) {
            currindex = (currindex + k - 1) % array.size();
            array.remove(currindex);
        }
        return array.get(0);
    }


    public static int function2(int n, int k){
        return recfunction(n, k) + 1;
    }

    public static int recfunction(int n, int k){
        if(n == 1){
            return 0;
        }
        return (recfunction(n - 1, k) + k) % n;
    }


}
