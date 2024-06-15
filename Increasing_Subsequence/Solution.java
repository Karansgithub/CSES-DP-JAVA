import java.util.*;
 
public class Solution {
    static long[][][][] dp = new long[20][10][2][2];
 
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
 
 
        List<Integer> longestSequence = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(longestSequence, num);
            if (index < 0)
                index = -(index + 1);
            if (index == longestSequence.size())
                longestSequence.add(num);
            else
                longestSequence.set(index, num);
        }
        System.out.println(longestSequence.size());
        
    }
}

// Dp Solution but but TLE in java
 
// import java.util.*;
 
// public class Solution {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
 
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
 
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (arr[i] > arr[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }
 
//         int maxSubsequenceLength = 0;
//         for (int length : dp) {
//             maxSubsequenceLength = Math.max(maxSubsequenceLength, length);
//         }
 
//         System.out.println(maxSubsequenceLength);
//     }
// }