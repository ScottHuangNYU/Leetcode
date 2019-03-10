package leetcode.Tree;

public class SameTree {
    public boolean solution(TreeNode p, TreeNode q){
        if(p == null || q == null ) return q == p;

        if(p.val != q.val) return false;

        return solution(p.left, q.left) && solution(p.right, q.right);
    }
}
