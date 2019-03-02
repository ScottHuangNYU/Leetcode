package leetcode;


import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    private static String s;

    public static String serialize(TreeNode root){

        s = "";
        preorder(root);

        return s;
    }

    public static void preorder(TreeNode node){
        if(node == null){
            s += "null,";
        }else{
            s += String.valueOf(node.val) + ",";
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static TreeNode deserialize(String data){
        String[] strs = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        TreeNode root = dfs(list);
        return root;
    }

    public static TreeNode dfs(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = dfs(list);
        root.right = dfs(list);

        return root;

    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);

        root.left = left;
        root.right = right;
        right.left = rightL;
        right.right = rightR;

        System.out.println(serialize(root));
    }
}
