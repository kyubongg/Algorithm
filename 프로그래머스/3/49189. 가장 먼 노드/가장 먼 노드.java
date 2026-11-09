import java.util.*;

class Solution {
    
    static List<Integer>[] nodes;
    static Map<Integer, Integer> map;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 1번부터 각각의 노드의 최단거리를 구한다.
        // 목적지까지 가면서 지나가는 간선의 수를 기록한다.
        // 목적지에 도착했을 때 현재 노드까지 오는데 통행한 간선의 수 배열의 인덱스에 +1을 한다.
        
        nodes = new ArrayList[n+1];
        map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
    
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        // 최단거리 탐색 시작
        bfs(1, n);
        
        int maxDist = Collections.max(map.keySet());
        return map.get(maxDist);
    }
    
    static void bfs(int start, int n){
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n+1];
        
        isVisited[start] = true;
        q.add(new int[] {start, 0});  // 현재 노드 번호, 지나온 간선의 수
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int next : nodes[now[0]]) {
                
                int nextEdge = now[1] + 1; // 간선을 한개 지남
                
                // 방문하려는 노드가 이미 방문된 노드면 패스
                if (!isVisited[next]) {    
                    map.put(nextEdge, map.getOrDefault(nextEdge, 0) + 1);
                    isVisited[next] = true;
                    q.add(new int[] {next, nextEdge});
                } 
                
            }
            
        }
    }
}








