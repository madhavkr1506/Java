import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class string_basic {

    public static boolean anagramString(String string1, String string2){
        string1 = string1.replaceAll("\\s","").toLowerCase();
        string2 = string2.replaceAll("\\s","").toLowerCase();

        if(string1.length() != string2.length()){
            return false;
        }

        char[] char_array1 = string1.toCharArray();
        char[] char_array2 = string2.toCharArray();
        Arrays.sort(char_array1);
        Arrays.sort(char_array2);
        
        return Arrays.equals(char_array1, char_array2);
    }

    public static boolean find_string_element(String[] array, String find){
        // return Arrays.stream(array).anyMatch(e -> e.equalsIgnoreCase(find));

        List<String> name_list = Arrays.asList(array);
        return name_list.stream().map(String::toLowerCase).anyMatch(e -> e.equals(find.toLowerCase()));
    }



    public static void main(String[] args) {
        // String string1 = "Madhav";
        // String string2 = "vahdam";

        // if(anagramString(string1, string2)){
        //     System.out.println("They are anagram string");
        // }

        // String[] array = {"Madhav","Krishna","Gopal","Hanuman","Keshav"};

        // if((find_string_element(array, "madhav"))){
        //     System.out.println("Yes it is present in the string");
        // }


        // String string1 = "Madhavkr";
        // if(find_integer_in_string(string1)){
        //     System.out.println("String contain integer value");
        // }




    }

    public static boolean find_integer_in_string(String string){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();

        
    }
}
