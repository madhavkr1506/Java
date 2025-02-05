import java.util.ArrayList;
import java.util.List;

public class trie_question1 {
    public static void main(String[] args) {

        String str = "ap";
        String[] words = {"apple","app","apex","banana","bat","battle"};

        Trie root = new Trie();
        
        for(String str_ : words){
            insertInTrie(root, str_);
        }

        // System.out.println(startsWith(root, str));

        // StringBuilder maxPrefixString = new StringBuilder();

        // longestPrefix(root, new StringBuilder(), maxPrefixString);

        // System.out.println(maxPrefixString);

        List<String> autoCompleteList = autoComplete(root, str);
        System.out.println(autoCompleteList);



        
    }
    static class Trie{
        boolean endsofword;
        Trie[] children;

        Trie(){
            children = new Trie[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }


    public static void insertInTrie(Trie root, String str){
        Trie current = root;
        for(int i=0;i<str.length();i++){
            int index = str.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new Trie();
            }
            if(i == str.length() - 1){
                current.children[index].endsofword = true;
            }
            current = current.children[index];
        }
    }


    public static boolean searchInTrie(Trie root, String str){
        Trie current = root;

        for(int i=0;i<str.length();i++){
            int index = str.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            if(i == str.length() - 1 && current.children[index].endsofword == false){
                return false;
            }

            current = current.children[index];
        }
        return true;
    }

    public static boolean startsWith(Trie root, String str){

        Trie current = root;

        for(int i=0;i<str.length();i++){
            int index = str.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }

            current = current.children[index];
        }
        return true;
    }

    public static void longestPrefix(Trie root, StringBuilder temp, StringBuilder maxPrefix){
        Trie current = root;
        if(current == null){
            return;
        }

        for(int i=0;i<26;i++){
            if(current.children[i] != null && current.children[i].endsofword == true){
                temp.append((char)(i + 'a'));
                if(temp.length() > maxPrefix.length()){
                    maxPrefix.setLength(0);
                    maxPrefix.append(temp);
                }
                longestPrefix(current.children[i], temp, maxPrefix);
                
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static List<String> autoComplete(Trie root, String prefix){
        List<String> prefixString = new ArrayList<>();

        Trie current = root;

        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null){
                return prefixString;
            }

            current = current.children[index];
        }

        dfs(current,prefix,prefixString);
        return prefixString;

    }

    public static void dfs(Trie current, String prefix, List<String> prefixString){
        if(current.endsofword){
            prefixString.add(prefix);
        }

        for(int i=0;i<26;i++){
            if(current.children[i] != null){
                dfs(current.children[i], prefix+(char)(i+'a'), prefixString);
            }
        }
    }
}
