package leetcode;

public class ConnectNextRightPoint {

    public void connect(TreeLinkNode root){

        if(root == null) return;


        while(root != null){
            TreeLinkNode dummy = new TreeLinkNode(9527);
            TreeLinkNode cur = dummy;
            while(root != null){
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }

                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }

                root = root.next;
            }
            root = dummy.next;
        }
    }
}

class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    int val;
    TreeLinkNode(int val){
        this.val = val;
    }
}