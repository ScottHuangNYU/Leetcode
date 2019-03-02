package leetcode.Tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode min = stack.pop();
        TreeNode node = min.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }

        // hi scott
        return min.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
