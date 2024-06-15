import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    static int solve(int n, char grid[][], int i, int j, int dp[][]) {
        if (i >= n || j >= n || grid[i][j] == '*') {
            return 0;
        }

        if (i == n - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = (solve(n, grid, i + 1, j, dp) + solve(n, grid, i, j + 1, dp)) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char grid[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }
        int dp[][] = new int[n][n];
        // for(int i=0;i<n;i++){
        // for(int j=0;j<n;j++){
        // dp[i][j]=-1;
        // }
        // }
        // System.out.println(solve(n,grid,0,0,dp));
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 0) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}