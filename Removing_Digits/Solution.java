import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    static long solve(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;
            dp[i] = Integer.MAX_VALUE;
            while (temp > 0) {
                int d = temp % 10;
                dp[i] = Math.min(dp[i], 1 + dp[i - d]);
                temp = temp / 10;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }
}