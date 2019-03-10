package DrawBridgeInterview;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderBT {
    private int negativeLevel;
    private int positiveLevel;
    public void print_Binary_Tree_Vertical_Order(TreeNode root){
        if(root == null) return;
        findWidthOfTree(root);
        for(int i = negativeLevel; i <= positiveLevel; i++){
            print(root, i,0);
            System.out.println();
        }
    }

    private void findWidthOfTree(TreeNode root){
        TreeNode left = root.left;

        while(left != null){
            negativeLevel--;
            left = left.left;
        }

        TreeNode right = root.right;
        while (right != null){
            positiveLevel++;
            right = right.right;
        }
    }
    private void print(TreeNode root, int NoLine, int curLine){
        if(root == null) return;

        if(curLine == NoLine) System.out.print(root.val + " ");

        print(root.left, NoLine, curLine - 1);
        print(root.right, NoLine, curLine + 1);
    }

    public void nlongMethod(TreeNode root){
        if(root == null) return;

        Map<Integer, List<TreeNode>> map = new TreeMap<>();

        findLevel(root, 0, map);

        for(Map.Entry<Integer,List<TreeNode>> entry : map.entrySet()){
            for(TreeNode node : entry.getValue()){
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

    public void findLevel(TreeNode root, int level, Map<Integer,List<TreeNode>> map){
        if(root == null) return;
        if(!map.containsKey(level)) {
            List<TreeNode> list = new LinkedList<>();
            list.add(root);
            map.put(level,list);
        }else {
            List<TreeNode> list = map.get(level);
            list.add(root);
        }
        findLevel(root.left, level - 1, map);
        findLevel(root.right, level + 1, map);

    }
    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        VerticalOrderBT a = new VerticalOrderBT();


        System.out.println("vertical order traversal is :");
        a.nlongMethod(root);
    }
}
