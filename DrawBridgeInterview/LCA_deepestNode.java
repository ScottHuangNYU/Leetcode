package DrawBridgeInterview;

public class LCA_deepestNode {

        public Integer solution(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] result = helper(root);
            return result[1];
        }
        private int[] helper(TreeNode root) {
            if (root == null) {
                return new int[]{-1, 0};
            }
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            if (left[0] > right[0]) {
                return new int[]{left[0]+1, left[1]};
            } else if (left[0] < right[0]) {
                return new int[]{right[0]+1, right[1]};
            } else {
                return new int[]{left[0]+1, root.val};
            }
        }

        public static void main(String[] args) {
            LCA_deepestNode test = new LCA_deepestNode();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.left = new TreeNode(6);
            root.left.right.right = new TreeNode(6);
            root.left.left = new TreeNode(8);

            System.out.println(test.solution(root));
        }

    }
