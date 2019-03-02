package leetcode;

import jdk.nashorn.api.tree.Tree;

public class InorderPredecessorInBST {

    public static TreeNode solution(TreeNode root, TreeNode p){

        if(root == null) return null;

        if(root.val >= p.val) return solution(root.left, p);
        else{
            TreeNode right = solution(root.right, p);
            return right == null ? root : right;
        }
    }
}
