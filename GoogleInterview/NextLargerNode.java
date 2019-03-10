package GoogleInterview;

public class NextLargerNode {
    public Node solution(Node node){
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            while(node.parent != null && node.val > node.parent.val){
                node = node.parent;
            }
            return node.parent;
        }

    }
}

class Node{
    int val;
    Node left,right,parent;
    public Node(int v){val = v;}
}
