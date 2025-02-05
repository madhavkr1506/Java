import java.util.ArrayList;
import java.util.List;

public class word_break_two {
    public static void main(String[] args) {
        String string = "catsanddog";
        String[] dictionary = {"cat","cats","and","dog","sand"};

        Trie trieStructure = new Trie();
        for(String str : dictionary){
            insertion(trieStructure, str);
        }


        List<String> sentences = wordbreak(trieStructure, string);
        System.out.println(sentences);


    }

    static class Trie{
        boolean endsofword;
        Trie[] children;
        Trie(){
            this.children = new Trie[26];

            for(int i=0;i<26;i++){
                this.children[i] = null;
            }
        }
    }

    public static void insertion(Trie root, String word){

        Trie current = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new Trie();
            }
            if(i == word.length() - 1){
                current.children[index].endsofword = true;
            }

            current = current.children[index];
        }
        
    }

    public static boolean searching(Trie root, String word){
        Trie current = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            if(i == word.length() - 1 && current.children[index].endsofword == false){
                return false;
            }
            current = current.children[index];
        }

        return true;
    }

    public static List<String> wordbreak(Trie root, String word){
        List<String> result = new ArrayList<>();
        wordbreakdown(root, word, "", result);
        return result;
    }

    public static void wordbreakdown(Trie root, String word, String sentence, List<String> result){
        if(word.isEmpty()){
            result.add(sentence.trim());
            return;
        }

        for(int i=0;i<word.length();i++){
            String prefix = word.substring(0, i+1);
            if(searching(root, prefix)){
                String suffix = word.substring(i+1);
                wordbreakdown(root, suffix, sentence + prefix + " ", result);
            }
        }
    }
}
