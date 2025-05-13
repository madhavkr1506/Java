import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode_212 {
    public static void main(String[] args) {
        char[][] boards = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};

        List<String> result = function1(boards, words);
        System.err.println(result);

    }

    static class Trie{
        boolean endOfWord;
        Trie[] trie;
        Trie(){
            endOfWord = true;
            trie = new Trie[26];

            for(int i=0;i<26;i++){
                trie[i] = null;
            }
        }
    }

    public static void insertWord(Trie root, String word){
        Trie current = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(current.trie[index] == null){
                current.trie[index] = new Trie();
            }
            if (i == word.length() - 1){
                current.trie[index].endOfWord = true;
            }

            current = current.trie[index];
            
        }
    }

    public static List<String> function1(char[][] boards, String[] words){
        Trie root = new Trie();
        HashSet<String> wordSet = new HashSet<>();
        for(int i=0;i<words.length;i++){
            insertWord(root, words[i]);
            wordSet.add(words[i]);
        }

        StringBuilder path = new StringBuilder();
        HashSet<String> uniqueWords = new HashSet<>();
        boolean[][] visited = new boolean[boards.length][boards[0].length];

        for(int i=0;i<boards.length;i++){
            for (int j=0;j<boards[i].length;j++){
                dfs(boards, i, j, root, path, visited, wordSet, uniqueWords);
            }
        }

        return new ArrayList<>(uniqueWords);
    }

    public static void dfs(char[][] boards, int row, int col, Trie node, StringBuilder path, boolean[][] visited, HashSet<String> wordSet, HashSet<String> uniqueWords){
        if(row < 0 || row >= boards.length || col < 0 || col >= boards[0].length || visited[row][col]){
            return;
        }

        char c = boards[row][col];
        int index = c - 'a';
        Trie nextNode = node.trie[index];

        if(nextNode == null){
            return;
        }

        path.append(c);
        visited[row][col] = true;

        String currentWord = path.toString();
        if(nextNode.endOfWord && wordSet.contains(currentWord)){
            uniqueWords.add(currentWord);
            wordSet.remove(currentWord);
        }

        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++){
            dfs(boards, row + rowOffsets[k], col + colOffsets[k], nextNode, path, visited, wordSet, uniqueWords);
        }

        path.deleteCharAt(path.length() - 1);
        visited[row][col] = false;
    }
}
