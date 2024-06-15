import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    static void solve(int n, long dp[][]) {
        for (int i = 1; i < n; i++) {
            dp[i][0] = (2 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (4 * dp[i - 1][1] + dp[i - 1][0]) % MOD;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int q[] = new int[t];
        int n = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            q[i] = sc.nextInt();
            if (n < q[i]) {
                n = q[i];
            }
        }
        long dp[][] = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        solve(n, dp);
        for (int i = 0; i < t; i++) {
            System.out.println((dp[q[i] - 1][0] + dp[q[i] - 1][1]) % MOD);
        }
    }
}