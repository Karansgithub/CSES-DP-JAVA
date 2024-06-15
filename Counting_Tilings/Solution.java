import java.util.*;
 
public class Solution {
    static final int MOD = 1000000007;
    static long[][] dp = new long[1050][2050];;
    static void nextBitMask(int n, int curr_mask, int new_mask, int j, ArrayList<Integer> nextMask) {
        if (j == n) {
            nextMask.add(new_mask);
            return;
        }
        if (j + 1 < n && ((1 << j & curr_mask) == 0) && ((1 << (j + 1) & curr_mask) == 0)) {
            nextBitMask(n, curr_mask, new_mask, j + 2, nextMask);
        }
        if ((1 << j & curr_mask) == 0) {
            nextBitMask(n, curr_mask, new_mask + (1 << j), j + 1, nextMask);
        }
        if ((1 << j & curr_mask) != 0) {
            nextBitMask(n, curr_mask, new_mask, j + 1, nextMask);
        }
    }
    
    static long solve(int n, int m, int i, int mask) {
        if (i == m) {
            if (mask == 0)
                return 1;
            else
                return 0;
        }
    
        if (dp[i][mask] != -1)
            return dp[i][mask];
    
        ArrayList<Integer> nextMask = new ArrayList<>();
        nextBitMask(n, mask, 0, 0, nextMask);
    
        long ans = 0;
        for (int x : nextMask) {
            ans = (ans % MOD + solve(n, m, i + 1, x) % MOD) % MOD;
        }
        return dp[i][mask] = ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(n, m, 0, 0));
 
        
    }
}
