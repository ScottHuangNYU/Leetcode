package GoogleInterview;

import java.util.ArrayList;
import java.util.List;

public class LongestPath {
    int longestPath;
    NewNode ansRoot;
    public String longestPath(NewNode root){
        depth(root);

        StringBuilder sb = new StringBuilder();

        sb.insert(0,ansRoot.val);

        NewNode left = ansRoot.left;

        while(left != null){
            sb.insert(0,left.val);

            if(left.left != null && left.right != null && left.left.height >= left.right.height || left.right == null) left = left.left;
            else if(left.left != null && left.right != null && left.left.height < left.right.height || left.left == null)left = left.right;
        }

        NewNode right = ansRoot.right;

        while(right != null){
            sb.append(right.val);
            if(right.left != null && right.right != null && right.left.height >= right.right.height || right.right == null) right = right.left;
            else if(right.left != null && right.right != null && right.left.height < right.right.height || right.left == null) right = right.right;
        }

        return sb.toString();
    }

    public int depth(NewNode node){
        if(node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        if(longestPath < leftDepth + rightDepth + 1){
            ansRoot = node;
            longestPath = leftDepth + rightDepth + 1;
        }
        node.height = Math.max(leftDepth,rightDepth) + 1;
        return node.height;
    }



    public static void main(String[] args){
        NewNode root = new NewNode(1);
        NewNode left = new NewNode(2);
        NewNode right = new NewNode(3);
        NewNode leftl = new NewNode(4);
        NewNode leftR = new NewNode(5);
        NewNode leftLR = new NewNode(8);
        NewNode leftRL = new NewNode(6);
        NewNode leftRR  = new NewNode(7);
        NewNode leftLRL = new NewNode(9);
        root.left = left;
        root.right = right;
        left.left = leftl;
        left.right = leftR;
        leftl.right = leftLR;
        leftR.left = leftRL;
        leftLR.left = leftLRL;
        leftR.right = leftRR;
        LongestPath a = new LongestPath();

        System.out.println(a.longestPath(root));
    }
}

class NewNode{
    int height, val;
    NewNode left, right;
    public NewNode(int v){val = v;}
}
