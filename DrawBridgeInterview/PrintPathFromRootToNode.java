package DrawBridgeInterview;

import java.util.LinkedList;
import java.util.List;

public class PrintPathFromRootToNode {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public List<Integer> printPath(TreeNode root, TreeNode des){

        List<Integer> res = new LinkedList<>();
        dfs(root, des, res);
        return res;
    }

    private boolean dfs(TreeNode cur, TreeNode des, List<Integer>res){
        if(cur == null) return false;

        if(cur == des || dfs(cur.left, des, res) || dfs(cur.right, des,res)){
            res.add(0,cur.val);
            return true;
        }
        return false;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        TreeNode n1 = new TreeNode (4);
        root.left.left = n1;
        root.left.right = new TreeNode (5);
        TreeNode n2 = new TreeNode (8);
        root.left.right.right = n2;
        root.left.right.left = new TreeNode (7);

        PrintPathFromRootToNode i = new PrintPathFromRootToNode();

        System.out.println(i.printPath(root,n2));
    }

}
