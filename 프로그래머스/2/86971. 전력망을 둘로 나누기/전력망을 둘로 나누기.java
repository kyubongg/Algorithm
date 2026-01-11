import java.util.*;
class Solution {
    
    static List<Integer>[] edges;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        edges = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        
        for(int i = 0; i < wires.length; i++) {
            
            int[] edge = wires[i];
            
            int from = edge[0];
            int to = edge[1];
            
            // 무방향 그래프이므로 둘 다 추가
            edges[from].add(to);
            edges[to].add(from);
            
        }
        
        // for(int i = 1; i < edges.length; i++) {
        //     System.out.println(edges[i]);
        // }
        
        for(int i = 0; i < wires.length; i++) {
            int[] nodes = wires[i];
            
            int node1 = nodes[0];
            int node2 = nodes[1];
            
            int count = bfs(node1, node2, n);
            
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        
        return answer;
    }
    
    static int bfs(int start, int skip, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        q.add(start);
        visited[start] = true;
        
        visited[skip] = true;
        
        int count = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int next : edges[node]) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        
        return count;
        
    }
}