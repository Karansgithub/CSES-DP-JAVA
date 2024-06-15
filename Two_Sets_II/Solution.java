import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = (n * (n + 1)) / 2;

        if (sum % 2 != 0) {
            System.out.println(0);
            return;
        }

        int target = sum / 2;
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= i; j--) {
                dp[j] = (dp[j] + dp[j - i]) % MOD;
            }
        }

        System.out.println(dp[target] * modInverse(2, MOD) % MOD);
    }

    private static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    private static long power(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}