import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    static long solve(int n, int m) {
        long dp[][] = new long[n + 1][m + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                // horizontal cut
                for (int h = 1; h < i; h++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - h][j] + dp[h][j] + 1);
                }
                // vertical cut
                for (int v = 1; v < j; v++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][v] + dp[i][j - v] + 1);
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solve(n, m));

    }
}