// Boyer - Moore Voting Algorithm

import java.util.ArrayList;

public class winter_gameid1003 {
    public static void main(String[] args) {
        int[] array = {2,2,1,1,1,2,2};
        // int maxcount = findelemostcount(array);
        // System.out.println("Maximum count candidate = " + maxcount);

        System.out.println("List: " + majority2(array));

    }
    // public static int findelemostcount(int[] array){
    //     int n = array.length;
    //     int count = 0;
    //     int candidate = array[0];
    //     for(int i=0;i<n;i++){
    //         if(count == 0){
    //             candidate = array[i];
    //         }
    //         if(candidate == array[i]){
    //             count++;
    //         }else{
    //             count--;
    //         }
    //     }
    //     return candidate;
    // }


    public static ArrayList<Integer> majority2(int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i : array){
            if(candidate1 == i){
                count1++;
            }
            else if(candidate2 == i){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = i;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = 0;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i : array){
            if(i == candidate1){
                count1++;
                
            }
            else if(i == candidate2){
                count2++;
                
            }
        }

        if(count1 > array.length / 3){
            list.add(candidate1);
        }
        if(count2 > array.length / 3){
            list.add(candidate2);
        }

        return list;
        
    }

    
}
