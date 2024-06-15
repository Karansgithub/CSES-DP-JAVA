import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    static int solve(String s1, String s2, int n, int m, int i, int j, int dp[][]) {
        if (i == n)
            return m - j;
        if (j == m)
            return n - i;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, n, m, i + 1, j + 1, dp);
        } else {
            int add = 1 + solve(s1, s2, n, m, i + 1, j, dp);
            int rem = 1 + solve(s1, s2, n, m, i, j + 1, dp);
            int rep = 1 + solve(s1, s2, n, m, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(add, Math.min(rem, rep));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(s1, s2, n, m, 0, 0, dp));
    }
}