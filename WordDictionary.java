package leetcode;

import java.util.Map;

public class WordDictionary {
    class Tried{
        char val;
        Map<Character, Tried> children;
        boolean isWord;
        public Tried(){}
        public Tried(char val){
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    Tried root;
    public WordDictionary() {
        root = new Tried();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Map<Character, Tried> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            Tried cur;
            if(!children.containsKey(c)){
                cur = new Tried(c);
                children.put(c, cur);
            }else{
                cur = children.get(c);
            }
            children = cur.children;
            if(i == word.length() - 1) cur.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isInDict(word, 0, root);
    }

    public boolean isInDict(String word, int index, Tried node){
        if(index == word.length()) return node.isWord;
        char c = word.charAt(index);
        Map<Character, Tried> children = node.children;
        if(c == '.'){
            for(Character key : children.keySet()){
                if(isInDict(word, index + 1, children.get(key))) return true;
            }
        }else{
            if(children.containsKey(c) && isInDict(word, index + 1, children.get(c))) return true;
        }
        return false;
    }

     public static void main(String[] args){
         WordDictionary dict = new WordDictionary();
         dict.addWord("bad");
         //dict.addWord("dad");
         //dict.addWord("mad");
     }
}
