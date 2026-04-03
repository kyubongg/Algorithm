import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        getDungeons(dungeons, 0, new int[dungeons.length], k);
        
        return answer;
    }
    
    // 던전 순서를 재귀로 돌림
    static void getDungeons(int[][] dungeons, int depth, int[] orders, int k) {
        if (depth == dungeons.length) {
            int result = getTired(dungeons, orders, k);
            answer = Math.max(answer, result);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            orders[depth] = i;
            getDungeons(dungeons, depth+1, orders, k);
            visited[i] = false;
        }
        
    }
    
    static int getTired(int[][] dungeons, int[] orders, int k) {
        
        int cnt = 0;
        for (int i = 0; i < orders.length; i++) {
            int order = orders[i];
            
            
            if (k >= dungeons[order][0] && k - dungeons[order][1] >= 0) {
                k -= dungeons[order][1];
                cnt++;
            }
        }
        
        return cnt;
    }
    
}