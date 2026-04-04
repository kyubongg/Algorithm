import java.util.*;
class Solution {
    
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        
        List<Integer>[] computerArr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            computerArr[i] = new ArrayList<>();
        }
        
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 != i && computers[i-1][j] == 1) {
                    computerArr[i].add(j+1);
                }
            }
        }
        
        for (List<Integer> arr : computerArr) {
            System.out.println(arr);
        }
        
        bfs(n, computerArr);
        
        return answer;
    }
    
    static void bfs(int n, List<Integer>[] computerArr) {
        
        
        boolean[] visited = new boolean[n+1];
        
        int tempN = n;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) continue;
            
            Queue<Integer> q = new ArrayDeque<>();
            
            q.add(i);
            visited[i] = true;
            
            int cnt = 0;
            while (!q.isEmpty()) {
                int curr = q.poll();
                
                if (computerArr[i].size() == 0) continue;
                
                for (int next : computerArr[curr]) {
                    if (visited[next]) continue;
                    
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
            
            if (tempN - cnt >= 0) {
                tempN -= cnt;
                answer++;
            }
        }
    }
}