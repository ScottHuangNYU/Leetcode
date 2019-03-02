package leetcode;

import jdk.nashorn.api.tree.Tree;

public class InorderSuccessorInBST {

    public static TreeNode solution(TreeNode root, TreeNode p){
        if(root == null) return null;

        if(root.val <= p.val) return solution(root.right, p);
        else{
            TreeNode left = solution(root.left,p);
            return left == null ? root : left;
        }
    }
}
