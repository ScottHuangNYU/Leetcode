package leetcode.Tree;

import java.util.List;

public class DepthOfTreeStructure {
    int max = 0;
    public int topDown(Node root){
        if(root == null) return 0;

        dfs(root, 1);

        return max;
    }
    public void dfs(Node node, int h){
        if(node == null) return;

        max = Math.max(max, h);

        for(Node child : node.children){
            dfs(child, h + 1);
        }
    }



    public int buttomUp(Node root){

        return helper(root);
    }

    public int helper(Node node){
        if(node == null) return 0;

        int max = 0;
        for(Node child : node.children){
            max = Math.max(helper(child), max);
        }
        return max + 1;
    }
}
 class Node{
    List<Node> children;
    int val;

    public Node(List<Node> children, int val){
        this.children = children;
        this.val = val;
    }
 }