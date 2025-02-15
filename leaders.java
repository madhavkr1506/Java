
public class leaders {

    public static void main(String[] args) {
        // int[] array = {16, 19, 4, 3, 8, 3};

        // for(int i=0;i<array.length;i++){
        //     int j;
        //     for(j=i+1;j<array.length;j++){
        //         if(array[i] <= array[j]){
        //             break;
        //         }
        //     }
        //     if(j == array.length){
        //         System.out.print(array[i] + " ");
        //     }

        // }


        // int[] array = {2, 3, 10, 6, 4, 8, 1};
        // int maxDiff = array[1] - array[0];
        // for(int i=0;i<array.length;i++){
        //     for(int j=i+1;j<array.length;j++){
        //         if(array[j] - array[i] > maxDiff){
        //             maxDiff = array[j] - array[i];
        //         }
        //     }
        // }

        // System.out.println(maxDiff);


        // String str = "aaaa";

        // int n = str.length();

        // int[] lps = new int[n];

        // int length = 0;
        // for(int i=1;i<n;i++){
        //     if(str.charAt(i) == str.charAt(length)){
        //         length++;
        //         lps[i] = length;
        //         i++;
        //     }else{
        //         if(length == 0){
        //             lps[i] = 0;
        //             i++;
        //         }else{
        //             length = lps[length - 1];
        //         }
        //     }
        // }

        // System.out.println(lps[n-1]);



        // int n=10;
        // int m=20;
        // int q = n / m;
        // int n1 = q * m;
        // int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));
        // if(Math.abs(n - n1) < Math.abs(n - n2)){
        //     System.out.println(n1);
        // }
        // else{
        //     System.out.println(n2);
        // }



        // String str = "1A0B1";

        // int result = Character.getNumericValue(str.charAt(0));

        // for(int i=1;i<str.length();i+=2){
        //     int num = Character.getNumericValue(str.charAt(i+1));
        //     switch(str.charAt(i)){
        //         case 'A' :
        //         result = result & num;
        //         break;

        //         case 'B' :
        //         result = result | num;
        //         break;

        //         case 'C' :                
        //         result = result ^ num;
        //         break;

        //     }
        // }

        // System.out.println(result);


        // String str = "aaaaabbbccccccccdaa";
        // HashMap<Character,Integer> map = new HashMap<>();

        // for(char c : str.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0) + 1);
        // }


        // for(Map.Entry<Character,Integer> e : map.entrySet()){
        //     System.out.print(e.getKey()+""+e.getValue());
        // }

        // StringBuilder newStr = new StringBuilder();
        // for(int i=0;i<str.length();i++){
        //     char c = str.charAt(i);
        //     int count = 1;
        //     while((i + 1) < str.length() && str.charAt(i) == str.charAt(i + 1)){
        //         count++;
        //         i++;
        //     }

        //     newStr.append(c);
        //     if(count > 1){
        //         newStr.append(count);
        //     }

        // }

        // System.out.println(newStr.toString());


        String str = "abcdc";
        
        StringBuilder rev = new StringBuilder(str).reverse();

        for(int i=0;i<str.length();i++){
            if(str.substring(i).equals(rev.substring(0,str.length()-i))){
                System.out.println(rev.substring(str.length()-i));
                break;
            }
        }


    }

    
}