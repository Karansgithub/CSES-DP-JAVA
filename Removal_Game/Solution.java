import java.util.*;
 
public class Solution {
    static final int MOD = 1000000007;
 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        long dp[][]=new long[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0, j=len-1;j<n;i++,j++){
                if(len==1){
                    dp[i][j]=arr[i];
                }else if(len==2){
                    dp[i][j]=Math.max(arr[i],arr[j]);
                }else{
                    long ans1=arr[i]+Math.min(dp[i+1][j-1],dp[i+2][j]);
                    long ans2=arr[j]+Math.min(dp[i][j-2],dp[i+1][j-1]);
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        System.out.println(dp[0][n-1]);
        
    }
}