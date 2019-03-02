package leetcode.Tree;



public class InvertBinaryTree {

    public TreeNode solution(TreeNode root) {
        if (root == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = solution(right);
        root.right = solution(left);

        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}