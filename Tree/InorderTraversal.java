package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    static List<TreeNode> res1 = new LinkedList<>();
    static List<TreeNode> res2 = new LinkedList<>();
    public void inorderRecursive(TreeNode root){
        if(root.left != null) inorderRecursive(root.left);

        res1.add(root);

        if(root.right != null) inorderRecursive(root.right);
    }

    public void inorderIteration(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res2.add(node);
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

        InorderTraversal i = new InorderTraversal();

        //i.preorderRecursive(root);
        i.inorderIteration(root);
        for(TreeNode node : res2){
            System.out.println(node.val);
        }

    }
}
