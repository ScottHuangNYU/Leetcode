package GoogleInterview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTSumK {
    public List<Integer> solution(TreeNode root, int k){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();

        queue.offer(root);
        int curCount = 1, nextCount = 0, level = 0, sum = 0;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            curCount--;
            sum += cur.val;

            if(cur.left != null) {
                queue.offer(cur.left);
                nextCount++;
            }
            if(cur.right != null) {
                queue.offer(cur.right);
                nextCount++;
            }

            if(curCount == 0){
                if(sum == k) res.add(level);
                level++;
                curCount = nextCount;
                nextCount = 0;
                sum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(11);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(7);
        TreeNode leftl = new TreeNode(1);
        TreeNode lefR = new TreeNode(2);
        TreeNode rightL = new TreeNode(5);
        TreeNode rightR = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftl;
        left.right = lefR;
        right.left = rightL;
        right.right = rightR;
        BTSumK a = new BTSumK();
        List<Integer> list = a.solution(root,11);
        for(int i : list){
            System.out.println(i);
        }
    }
}
