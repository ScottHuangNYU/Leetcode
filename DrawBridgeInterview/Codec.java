package DrawBridgeInterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    private String sdata;
    // preOrder:
    public void preOrder(TreeNode root){
        if(root == null) sdata += "null,";
        else{
            sdata += String.valueOf(root.val) + ",";
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sdata = "";
        preOrder(root);
        return sdata;
    }

    // Decodes your encoded data to tree.
    public TreeNode reconstruct(List<String> list){
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);

        root.left = reconstruct(list);
        root.right = reconstruct(list);

        return root;
    }
    public TreeNode deserialize(String data) {
        String[] strsData = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(strsData));
        return reconstruct(list);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftL = new TreeNode(4);
        TreeNode leftR = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = leftL;
        left.right = leftR;
        Codec a = new Codec();
        System.out.println(a.deserialize(a.serialize(root)));
    }
}
