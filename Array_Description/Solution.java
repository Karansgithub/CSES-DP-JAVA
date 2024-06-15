import java.util.*;
 
public class Solution {
    static final int MOD = 1000000007;
 
    static long solve(int n,int m,int arr[],long dp[][]){
        for(int i=0;i<n;i++){
            if(i==0){
                if(arr[i]==0){
                    for(int j=1;j<=m;j++){
                        dp[i][j]=1;
                    }
                }else{
                    dp[0][arr[i]]=1;
                }
            }else{
                if(arr[i]==0){
                    for(int j=1;j<=m;j++){
                        dp[i][j]=(dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1])%MOD;
                    }
                }else{
                    int val=arr[i];
                    dp[i][val]=(dp[i-1][val-1]+dp[i-1][val]+dp[i-1][val+1])%MOD;
                }
            }
        }
        long result = 0;
        for (int j = 1; j <= m; j++) {
            result = (result + dp[n - 1][j]) % MOD;
        }
        return result;
 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long dp[][]=new long[n][m+2];
        System.out.println(solve(n,m,arr,dp));
 
        
    }
}
