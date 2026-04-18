import java.util.*;
class Solution {
    static int[] arr;
    static int[][] sQ;
    static int answer;
    static boolean[] visited;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        // 1~30까지의 수를 가지는 5자리의 비밀코드, 
        // 비밀코드 예측 횟수 10번 (1번당 5개)
        
        sQ = q;
        
        // 브루트포스 알고리즘 사용해서 모든 조합 탐색
        // 30C5 = 6 29 7 9 13 = 142506 * 5 * 5 = 3562650
        arr = new int[5];
        visited = new boolean[n+1];
        dfs (1, n, 0, ans);
        
        return answer;
    }
    
    static void dfs (int now, int end, int depth, int[] ans) {
        
        if (depth == 5) {
            boolean isPossible = solve(ans);
            if (isPossible) answer++;
            return;
        }
        
        for (int i = now; i <= end; i++) {
            if (!visited[i]) {
                
                visited[i] = true;
                arr[depth] = i;
                dfs (i+1, end, depth+1, ans);
                visited[i] = false;
            }
        }
    }
    
    static boolean solve (int[] ans) {
        
        int[] cnt = new int[sQ.length];
        
        // q에서 하나 꺼내옴
        for (int i = 0; i < sQ.length; i++) {
            int[] q = sQ[i];
            
            int nowCnt = 0;
            for (int j = 0; j < q.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (q[j] == arr[k]) {
                        nowCnt++;
                        break;
                    }
                }
            }
            
            cnt[i] = nowCnt;
        }
        
        for (int i = 0; i < ans.length; i++) {
            if (cnt[i] != ans[i]) return false;
        }
        
        return true;
    }
}