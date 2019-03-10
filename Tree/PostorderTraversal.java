package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
// left - right - root:
public class PostorderTraversal {
    private static List<TreeNode> res1 = new LinkedList<>();
    private static List<TreeNode> res2 = new LinkedList<>();
    public void postorderRecursive(TreeNode root){
        //对于一个node, 先把左子树所有node都加到res里， 再把右子树所有node都加入res，最后把自己加入res
        if(root.left != null) postorderRecursive(root.left);

        if(root.right != null) postorderRecursive(root.right);

        res1.add(root);
    }

    public void preoriderIteration(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preVisited = null;

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();

            if((node.left == null && node.right == null) || ((preVisited != null)
                && (preVisited == node.left || preVisited == node.right))){
                res2.add(node);
                preVisited = stack.pop();
            }else{
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
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

        PostorderTraversal i = new PostorderTraversal();

        //i.postorderRecursive(root);
        i.preoriderIteration(root);
        for(TreeNode node : res2){
            System.out.println(node.val);
        }

    }
}

