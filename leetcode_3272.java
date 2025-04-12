import java.util.ArrayList;
import java.util.List;

public class leetcode_3272 {

    public static void main(String[] args) {
        int good_integer = count_good_integer(3, 5);
        System.out.println(good_integer);

    }


    public static int count_good_integer(int n, int k){
        int lower_bound = n_digit_start(n);
        int upper_bound = n_digit_last(n);

        int count = 0;

        for(int i=lower_bound;i<=upper_bound;i++){
            String str = Integer.toString(i);
            List<String> all_perms = find_all_perms(str);
            for (String prem : all_perms){
                if(prem.charAt(0) == '0'){
                    continue;
                }
                if(chack_palindrome(prem) && Integer.parseInt(prem) % k == 0){
                    count++;
                    break;
                }
            }

        }
        return count;
    }


    public static boolean chack_palindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }



    public static List<String> find_all_perms(String str){      
        List<String> all_prems = new ArrayList<>();
        all_permutations(str, "", new boolean[str.length()], all_prems);    
        return all_prems;
    }

    public static void all_permutations(String str, String temp,boolean[] used, List<String> all_perms){
        if(temp.length() == str.length()){
            all_perms.add(temp);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(!used[i]){
                used[i] = true;
                all_permutations(str, temp + str.charAt(i), used, all_perms);
                used[i] = false;
            }
            
        }
    }

    public static int n_digit_start(int digit){
        return (int)Math.pow(10, digit - 1);
    }

    public static int n_digit_last(int digit){
        return (int)Math.pow(10, digit) - 1;
    }
    
}



