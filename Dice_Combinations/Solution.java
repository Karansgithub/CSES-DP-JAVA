import java.util.*;

class Solution {
    static int M = 1000000007;

    static int solve(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= i - 6 && j >= 0; j--) {
                dp[i] = (dp[i] + dp[j]) % M;
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
