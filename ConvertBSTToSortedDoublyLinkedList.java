package leetcode;

public class ConvertBSTToSortedDoublyLinkedList {
    Node1 pre;
    public Node1 solution(Node1 root){

        if(root == null) return null;

        Node1 dummy = new Node1(9527,null,null);

        pre = dummy;

        inoder(root);

        pre.right = dummy.right;
        dummy.right.left = pre;

        return dummy.right;
    }

    public void inoder(Node1 cur){
        if(cur == null) return;

        inoder(cur.left);

        pre.right = cur;
        cur.left = pre;
        pre = cur;

        inoder(cur.right);
    }
}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

