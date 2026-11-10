import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        
        // 전력망들이 어떻게 연결되어 있는지를 나타내는 인접 리스트 : nodes
        // 노드 번호가 1 ~ n으로 매겨져 있기 때문에 배열 길이는 n+1로 설정
        List<Integer>[] nodes = new ArrayList[n+1];       
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        // 간선 정보 저장
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            
            // 무방향 그래프이므로 양쪽에 다 추가
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        // wires의 길이는 n-1이므로 하나씩 골라서 해당 간선을 자르면 노드들이 어떻게 연결되어 있는지 보는 방법 사용
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            int diff = getDiff(nodes, wire, n);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    static int getDiff(List<Integer>[] nodes, int[] wire, int n){
        
        // 노드들간의 연결관계 파악용 배열
        int[] conn = new int[n+1];
        
        // BFS 사용
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        conn[1] = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next : nodes[curr]) {
                // 이번에 끊은 간선이면 패스
                if (curr == wire[0] && next == wire[1] || curr == wire[1] && next == wire[0]) continue;
                
                if (conn[next] != 0) continue;
                conn[next] = conn[curr];
                q.add(next);
            }  
        }
     
        
        // 연결 배열 정렬
        Arrays.sort(conn);
        
        // 정렬된 배열에서 각각의 개수가 몇개인지 확인
        int minCnt = 1;
        int maxCnt = 1;
        for (int i = 1; i <= n; i++) {
            if (conn[i] == conn[1]) minCnt++;
            else if (conn[i] == conn[conn.length-1]) maxCnt++;
        }
        
        return Math.abs(minCnt - maxCnt);
    }
}