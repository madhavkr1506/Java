public class Trie {

    static class Trie_{
        boolean endofword;
        Trie_[] trie;
        Trie_(){
            trie = new Trie_[26];
            for(int i=0;i<26;i++){
                trie[i] = null;
            }
        }

        public void insertIntrie(Trie_ root, String str){
            try{
                Trie_ current = root;
                for (int i=0;i<str.length();i++){
                    int index = str.charAt(i) - 'a';
                    if (current.trie[index] == null){
                        current.trie[index] = new Trie_();
                    }
                    if (i == str.length() - 1){
                        current.trie[index].endofword = true;
                    }
                    current = current.trie[index];
                }
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }

        public boolean serachInTrie(Trie_ root, String str){
            try{
                Trie_ current = root;
                for (int i=0;i<str.length();i++){
                    int index = str.charAt(i) - 'a';
                    if (current.trie[index] == null){
                        return false;
                    }
                    else if (i == str.length() - 1 && current.trie[index].endofword == false){
                        return false;
                    }
                    current = current.trie[index];
                }
                return true;

            }catch(Exception e){
                System.err.println(e.getMessage());
                return false;
            }
        }

        public boolean startsWith(Trie_ root, String prefix){
            try{
                Trie_ current = root;
                for(int i=0;i<prefix.length();i++){
                    int index = prefix.charAt(i) - 'a';
                    if (current.trie[index] == null){
                        return false;
                    }
                    current = current.trie[index];
                }
                return true;
            }catch(Exception e){
                System.err.println(e.getMessage());
                return false;
            }
        }

        public void longestPrefix(Trie_ root, StringBuilder temp, StringBuilder maxPrefix){
            try{
                Trie_ current = root;
                if (current == null) { return; }
                for(int i=0;i<26;i++){
                    if (current.trie[i] != null && current.trie[i].endofword == true){
                        temp.append(((char) (i + 'a')));
                        if (temp.length() > maxPrefix.length()){
                            maxPrefix.setLength(0);
                            maxPrefix.append(temp);
                        }
                        longestPrefix(current.trie[i], temp, maxPrefix);
                        temp.deleteCharAt(temp.length() - 1);
                    }
                }

            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {

        String[] words = {"apple","app","apex","banana","bat","battle"};
        Trie_ root = new Trie_();
        for (String str : words){
            root.insertIntrie(root, str);
        }

        String searchString = "apples";
        System.out.println(root.serachInTrie(root, searchString));

        String prefix = "app";
        System.out.println(root.startsWith(root, prefix));

        StringBuilder maxPrefixString = new StringBuilder();

        root.longestPrefix(root, new StringBuilder(), maxPrefixString);

        System.out.println(maxPrefixString);
    }


}