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
        int x = sc.nextInt();
        int price[] = new int[n];
        int page[] = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            page[j] = sc.nextInt();
        }

        // for(int i=0;i<n;i++){
        // for(int j=0;j<n;j++){
        // dp[i][j]=-1;
        // }
        // }
        // System.out.println(solve(n,grid,0,0,dp));
        long[] dp = new long[x + 1];

        for (int i = 0; i < n; i++) {
            for (int j = x; j >= price[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + page[i]);
            }
        }
        System.out.println(dp[x]);

    }
}