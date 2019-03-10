package leetcode.Tree;

public class UniqueBST {
    public static int solution(int n){
        //G(n) : the number of unique BST build by 1 to n. F(i, n) : the number of unique BST which root is i.
        //G(n) = F(1,n) + .... + F(n,n);
        //F(i,n) = G(i - 1)left subtree * G(n - i)right subtree

        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for(int i = 2; i <=n; i++){
            for(int j = 1; j <=i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    public static void main(String[] args){
        System.out.println(solution(4));
    }
}
