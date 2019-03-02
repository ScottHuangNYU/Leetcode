package leetcode;

import java.util.*;

public class distanceK {
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> solution(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null || K < 0) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        buildGraph(root, null);
        queue.offer(target);
        visited.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();

            if(K == 0){
                for(int i = 0; i < size; i++){
                    res.add(queue.poll().val);
                    return res;
                }
            }

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null && !visited.contains(cur.left)){
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }
                if(cur.right != null && !visited.contains(cur.right)){
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }
                if(map.get(cur) != null && !visited.contains(map.get(cur))){
                    queue.offer(map.get(cur));
                    visited.add(map.get(cur));
                }
            }
            K--;
        }
        return res;

    }

    public void buildGraph(TreeNode node,  TreeNode parent){
        if(node == null) return;

        map.put(node, parent);

        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode leftL = new TreeNode(6);
        TreeNode leftR = new TreeNode(2);
        TreeNode rightL = new TreeNode(0);
        TreeNode rightR = new TreeNode(8);
        TreeNode leftRL = new TreeNode(7);
        TreeNode leftRR = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        right.left = rightL;
        right.right = rightR;
        leftR.left = leftRL;
        leftR.right = leftRR;

        distanceK a = new distanceK();
        a.solution(root,left,2);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }