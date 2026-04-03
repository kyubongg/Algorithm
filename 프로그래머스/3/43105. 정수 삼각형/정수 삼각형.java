import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            
            // 본인 위랑 본인 위 -1을 보면됨
            for (int j = 0; j < triangle[i].length; j++) {
                // 본인 위
                int first = dp[i-1][j] + triangle[i][j];
                int second = 0;
                if (j - 1 >= 0) {
                    second = dp[i-1][j-1] + triangle[i][j];
                }
                // 본인 위 - 1
                
                
                dp[i][j] = Math.max(first, second);
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n-1][i], max);
        }
        return max;
    }
}