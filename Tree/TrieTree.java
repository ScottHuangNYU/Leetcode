package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieTree {

    private TrieNode root = new TrieNode();

    public void insert(String word){
         Map<Character, TrieNode> children = root.children;

         for(int i = 0; i < word.length(); i++){
             char c = word.charAt(i);

             TrieNode t;
             if(children.containsKey(c)){
                  t = children.get(c);
             }else{
                  t = new TrieNode(c);
                  children.put(c, t);
             }

             children = t.children;
             if(i == word.length() - 1) t.isWord = true;
         }
    }

    public List<String> search(String str){
        List<String> res = new ArrayList<>();

        Map<Character, TrieNode> children = root.children;
        TrieNode t;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
                sb.append(c);
            }else{
                return res;
            }
            if(i == str.length() - 1){
                sb.deleteCharAt(sb.length() - 1);
                dfs(t, sb, res);
            }
        }
        return res;
    }

    public void dfs(TrieNode t, StringBuilder sb, List<String> res){

        sb.append(t.var);

        if(t.isWord){
            res.add(sb.toString());
        }
        Map<Character, TrieNode> children = t.children;
        if(children.size() == 0 || children == null) return;
        for(char key : children.keySet()){
            t = children.get(key);
            dfs(t,sb,res);
        }
    }

    public static void main(String[] args){
        TrieTree tree = new TrieTree();
        tree.insert("sc");
        tree.insert("scot");
        tree.insert("scott");
        tree.insert("scotts");
        tree.insert("cat");

        System.out.println(tree.search("s"));
    }
}


class TrieNode{
    char var;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
    public TrieNode(){}
    public TrieNode(char var){
        this.var = var;
    }
}