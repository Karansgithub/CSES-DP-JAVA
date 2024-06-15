import java.util.*;

public class Solution {
    static long[][][][] dp = new long[20][10][2][2];

    static long mem(String s, int curr, int prev_digit, int leading_zero, int tight) {
        if (curr == 0)
            return 1;

        if (dp[curr][prev_digit][leading_zero][tight] != -1)
            return dp[curr][prev_digit][leading_zero][tight];

        int limit;

        if (tight == 0) {
            limit = 9;
        } else {
            limit = s.charAt(s.length() - curr) - '0';
        }

        long answer = 0;
        for (int curr_digit = 0; curr_digit <= limit; curr_digit++) {
            if (leading_zero == 0 && (curr_digit == prev_digit)) {
                continue;
            }
            int new_leading_zero = (leading_zero == 1 && curr_digit == 0) ? 1 : 0;
            int new_tight = (curr_digit == limit && tight == 1) ? 1 : 0;
            answer += mem(s, curr - 1, curr_digit, new_leading_zero, new_tight);
        }
        ;
        return dp[curr][prev_digit][leading_zero][tight] = answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long count1 = 0;
        for (long[][][] arr3D : dp) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }
        String str1 = Long.toString(a - 1);
        if (a != 0)
            count1 = mem(str1, str1.length(), 0, 1, 1);
        for (long[][][] arr3D : dp) {
            for (long[][] arr2D : arr3D) {
                for (long[] arr1D : arr2D) {
                    Arrays.fill(arr1D, -1);
                }
            }
        }
        String str2 = Long.toString(b);
        long count2 = mem(str2, str2.length(), 0, 1, 1);
        System.out.println(count2 - count1);

    }
}
