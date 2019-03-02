package leetcode;

public class wordSearch {
    private int rows;
    private int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        int[][] visited = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; i < cols; i++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, 0, i, j, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j, int[][] visited){
        if(i < 0 || i >= rows || j < 0 || j >= cols || word.charAt(index) != board[i][j] || visited[i][j] == 1) return false;

        if(index == word.length()-1) return true;
        visited[i][j] = 1;
        boolean top = dfs(board, word, index + 1, i - 1, j,visited);
        boolean down = dfs(board, word, index + 1, i + 1, j,visited);
        boolean left = dfs(board, word, index + 1, i, j -1,visited);
        boolean right = dfs(board, word, index + 1, i, j + 1,visited);
        visited[i][j] = 0;
        return top || down || left || right;
    }

    public static void main(String[] args){
        wordSearch a = new wordSearch();
        char[][] bo = {{'a','a'}};
        System.out.println(a.exist(bo,"aaa"));
    }
}
