import java.util.*;

class Solution {
    static int M = 1000000007;

    static int solve(int n, int sum, int coins[]) {
        int table[] = new int[sum + 1];

        table[0] = 0;

        for (int i = 1; i <= sum; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;

                }

        }

        if (table[sum] == Integer.MAX_VALUE)
            return -1;

        return table[sum];
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
    }
}