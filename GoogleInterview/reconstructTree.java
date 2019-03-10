package GoogleInterview;


import java.util.List;
import java.util.Stack;

public class reconstructTree {
    int cur = 0;
    public TreeNode reconstructI(List<Integer> preorder){
        if(preorder == null || preorder.size() == 0) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //TreeNode node = root;
        for(int i = 1; i < preorder.size(); i++){
            TreeNode node = new TreeNode(preorder.get(i));
            if(node.val < stack.peek().val) {
                stack.peek().left = node;
                stack.push(node);
            }else{
                TreeNode temp = stack.pop();
                while(!stack.isEmpty() && node.val > stack.peek().val){
                    temp = stack.pop();
                }
                temp.right = node;
                stack.push(node);
            }
        }
        return root;
    }

//    Index index = new Index();
    public TreeNode reconstructR(int[] pre){
        return helper(pre, cur, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] pre, int index, int maxValue, int minValue) {
        if(index >= pre.length) return null;

        TreeNode root = null;

        if(pre[index] > minValue && pre[index] < maxValue){

            root = new TreeNode(pre[index]);

//            preIndex = preIndex + 1;

//            if(index < pre.length){
                root.left = helper(pre, cur+1, pre[index], minValue);

                root.right = helper(pre, cur+1, maxValue, pre[index]);
//            }

        }
        return root;
    }

    void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }


    public static void main(String[] args) {
        reconstructTree tree = new reconstructTree();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        TreeNode root = tree.reconstructR(pre);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Index{
    int index = 0;
}