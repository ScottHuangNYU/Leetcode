package leetcode;

import jdk.nashorn.api.tree.Tree;

public class FlattenBinaryTreetoLinkedList {
    public void solution(TreeNode root){
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        solution(left);
        solution(right);

        root.right = left;

        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = right;
    }
}
