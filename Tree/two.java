package Tree;

public class two {
    private static String inorder;
    private static String preorder;
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        inorder = "";
        preorder = "";
        traverse(root);
        return inorder + "/" + preorder;
    }

    public static void traverse(TreeNode cur){
        if(cur == null) return;

        preorder += String.valueOf(cur.val) + ",";

        traverse(cur.left);

        inorder += String.valueOf(cur.val) + ",";

        traverse(cur.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode (2);
        TreeNode n2 = new TreeNode (3);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode (4);
        root.left.left = n3;
        TreeNode n4 = new TreeNode (5);
        root.left.right = n4;
        TreeNode n5 = new TreeNode (8);
        root.right.right = n5;
        TreeNode n6 = new TreeNode (7);

        System.out.println(serialize(root));
    }
}
