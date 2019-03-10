package DrawBridgeInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCAwithDup {
    private List<TreeNode> inorder;
    private List<TreeNode> postorder;
    public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b){
        inorder = new ArrayList<>();
        postorder = new ArrayList<>();

        inoderTraverse(root);
        postorderTraverse(root);

        List<Integer> aIndex = new ArrayList<>();
        List<Integer> bIndex = new ArrayList<>();

        for(int i = 0; i < inorder.size(); i++){
            if(inorder.get(i).val == a.val) aIndex.add(i);
            if(inorder.get(i).val == b.val) bIndex.add(i);
        }
        int minIndex = postorder.size();
        for(int i = 0; i < aIndex.size(); i++){
            for(int j = 0; j < bIndex.size(); j++){
                int maxIndex = -1;
                for(int k = aIndex.get(i) + 1; k < bIndex.get(j); k++){
                    int postIndex = postorder.indexOf(inorder.get(k));
                    if( postIndex > maxIndex){
                        maxIndex = postIndex;
                    }
                }
                minIndex = Math.min(maxIndex,minIndex);
            }
        }
        return postorder.get(minIndex);
    }
    public void inoderTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            inorder.add(node);
            root = root.right;
        }
    }

    public void postorderTraverse(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode preVistited = null;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();

            if((node.left == null && node.right ==null) || ((preVistited != null) && (preVistited == node.left || preVistited == node.right))){
                postorder.add(node);
                preVistited = stack.pop();
            }else{
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
        }

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