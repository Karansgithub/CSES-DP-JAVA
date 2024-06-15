import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    static void solve(int n, int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        boolean dp[][] = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]])
                    dp[i][j] = true;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= sum; i++) {
            if (dp[n][i])
                list.add(i);
        }

        System.out.println(list.size());

        for (int i : list) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve(n, arr);

    }
}