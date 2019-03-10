package DrawBridgeOA;

public class DiamondMine {
    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int n = grid.length;
        int p = n * 2 - 2;

        int[][][] dp = new int[n*2][n][n];


        // k = m + n - 2 the total steps when from (0,0) to (n-1, m-1)
        // dp[k][i][j] store after k steps
        // one path is at i row
        // another path is at j row
        // the maximum diamonds number
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < n; j++){
                dp[0][i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0][0] = grid[0][0];

        for (int k = 1; k <= p; k++){

            for (int i = 0; i < n; i++){

                for (int j = i; j < n; j++){
                    dp[k][i][j] = Integer.MIN_VALUE;
                    if (!isValid(k, i, j, grid)){
                        continue;
                    }

                    int iUpjUp = getValue(k-1, i-1, j-1, dp, grid);
                    int iUpjStay = getValue(k-1, i-1, j, dp, grid);
                    int iStayjUp = getValue(k-1, i, j-1, dp, grid);
                    int iStayjStay = getValue(k-1, i, j, dp, grid);

                    if (i == j){

                        dp[k][i][j] = Math.max(iUpjUp, Math.max(iUpjStay, Math.max(iStayjUp, iStayjStay)));
                        dp[k][i][j] += grid[i][k-i];

                    }else{

                        dp[k][i][j] = Math.max(iUpjUp, Math.max(iUpjStay, Math.max(iStayjUp, iStayjStay)));
                        dp[k][i][j] += grid[i][k-i] + grid[j][k-j];

                    }

                }

            }

        }
        return dp[p][n-1][n-1];

    }
    public int getValue(int step, int i, int j, int[][][] dp, int[][] mat){

        if (!isValid(step, i, j, mat)){
            return Integer.MIN_VALUE;
        }

        return dp[step][i][j];

    }
    public boolean isValid(int step, int rowi, int rowj, int[][] mat){

        int n = mat.length;
        int coli = step - rowi;
        int colj =  step - rowj;

        boolean res = (rowi >= 0) && (rowi < n) && (rowj >= 0) && (rowj < n) &&
                (coli >= 0) && (coli < n) && (colj >= 0) && (colj < n) &&
                (mat[rowi][coli] != -1) && (mat[rowj][colj] != -1);

        return res;

    }

    public static void main(String[] args){
        int[][] a = {{1,1,-1},{1,-1,1},{-1,1,1}};
        DiamondMine c = new DiamondMine();
        System.out.println(c.cherryPickup(a));
    }

}
