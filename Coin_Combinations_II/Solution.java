import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    static long solve(int n, int sum, int[] coins) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(solve(n, sum, coins));
    }
}