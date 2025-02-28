
package dynamicprogramming;

public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];

        // Fill the DP table using bottom-up approach
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], q);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dims = {1, 2, 3, 4};  // Matrix dimensions
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(dims));
    }
}

