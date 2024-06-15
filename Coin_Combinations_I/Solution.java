import java.util.*;

class Solution {
    static final int M = 1000000007;

    static long solve(int n, int sum, int coins[]) {
        long dp[] = new long[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            for (int c : coins) {
                if (c <= i)
                    dp[i] = (dp[i] + dp[i - c]) % M;
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(n, sum, arr));
        // System.out.println(memo(arr, n, sum, 0));
    }
}