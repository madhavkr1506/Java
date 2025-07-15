import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        String str = "catsanddog";
        String[] dictWord = {"cat","cats","and","sand","dog"};
        List<String> sentences = wordBreak(str, Arrays.asList(dictWord));
        System.out.println(sentences);
    }

    public static List<String> wordBreak(String str, List<String> wordDict) {
        try{
            trie root = new trie();
            for(String s : wordDict){
                insertTrie(root, s);
            }
            List<String> sentenceList = wordBreakWithTrie(root, str);
            return sentenceList;
            
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
        
    }

    public static List<String> wordBreakWithTrie(trie root, String str){
        try{
            List<String> result = new ArrayList<>();
            String temp = "";
            wordBreakUtil(root, str, temp, result);
            return result;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }

    }

    public static void wordBreakUtil(trie root, String str, String sentence, List<String> result){
        try{
            if(str.isEmpty()){
                result.add(sentence.trim());
                return;
            }
            for(int i=0;i<str.length();i++){
                String prefix = str.substring(0, i+1);
                if (searchTrie(root, prefix)){
                    String suffix = str.substring(i+1);
                    wordBreakUtil(root, suffix, sentence + prefix + " ", result);
                }
                

            }


        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static class trie{
        boolean endofword;
        trie[] children;
        trie(){
            children = new trie[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }

    }

    public static void insertTrie(trie root, String word){
        try{
            trie current = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null){
                    current.children[index] = new trie();
                }
                if (i == word.length() - 1){
                    current.children[index].endofword = true;
                }
                current = current.children[index];
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }

    public static boolean searchTrie(trie root, String word){
        try{
            trie current = root;
            for (int i=0;i<word.length();i++){
                int index = word.charAt(i) - 'a';
                if(current.children[index] == null){
                    return false;
                }else if(i == word.length() - 1 && current.children[index].endofword == false){
                    return false;
                }
                current = current.children[index];
            }
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        
    }

}
