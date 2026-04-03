import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        // 시간복잡도
        // 간선 하나씩 제거 : n-1
        // 제거한 후에 노드 연결된거 확인 : n-1
        // O(N^2)
        List<Integer>[] nodes = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        // 간선 하나씩 제거
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            int cnt = getNetworks(start, end, nodes);
            
            int diff = Math.abs(cnt - (n - cnt));
            
            answer = Math.min(answer, diff);
        }
        
        
        return answer;
    }
    
    
    // 연결된거 확인
    static int getNetworks(int start, int end, List<Integer>[] nodes) {
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[nodes.length];
        
        q.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!q.isEmpty()) {
            
            int curr = q.poll();
            
            for (int next : nodes[curr]) {
                
                if (curr == start && next == end) continue;
                
                if (!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    cnt++;                    
                }
                
            }
            
        }
        
        return cnt;
        
    }
}