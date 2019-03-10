package Tree;


import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    private static List<TreeNode> res1 = new LinkedList<>();
    private static List<TreeNode> res2 = new LinkedList<>();
    public void preorderRecursive(TreeNode root){

        res1.add(root);

        if(root.left != null) preorderRecursive(root.left);

        if(root.right != null) preorderRecursive(root.right);
    }

    public void preoriderIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                res2.add(root);
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode (2);
        TreeNode n2 = new TreeNode (3);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode (4);
        root.left.left = n3;
        TreeNode n4 = new TreeNode (5);
        root.left.right = n4;
        TreeNode n5 = new TreeNode (8);
        root.right.right = n5;
        TreeNode n6 = new TreeNode (7);
        root.right.left = n6;

        PreorderTraversal i = new PreorderTraversal();

        //i.preorderRecursive(root);
        i.preoriderIteration(root);
        for(TreeNode node : res2){
            System.out.println(node.val);
        }

    }
}


class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
