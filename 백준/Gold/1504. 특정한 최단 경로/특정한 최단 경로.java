import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[][] dp;
	static int N;
	static long INF = Long.MAX_VALUE / 2;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<int[]>[] nodes = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			nodes[from].add(new int[] {to, dist});
			nodes[to].add(new int[] {from, dist});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long[][] dist = new long[N + 1][1 << 3];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        
        // 시작점 자체가 v1이나 v2일 경우를 대비한 초기 비트 설정
        int startVisited = 0;
        if (1 == v1) startVisited |= (1 << 1);
        if (1 == v2) startVisited |= (1 << 2);
        
        pq.add(new long[]{1, 0, startVisited});
        dist[1][startVisited] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long currDist = curr[1];
            int visited = (int) curr[2];

            if (currDist > dist[node][visited]) continue;

            for (int[] next : nodes[node]) {
                int nextNode = next[0];
                int weight = next[1];
                
                // 다음 노드 방문 시의 비트 상태 결정
                int nextVisited = visited;
                if (nextNode == v1) nextVisited |= (1 << 1);
                if (nextNode == v2) nextVisited |= (1 << 2);

                // 핵심: nextVisited 상태의 최단 거리를 갱신해야 함
                if (dist[nextNode][nextVisited] > currDist + weight) {
                    dist[nextNode][nextVisited] = currDist + weight;
                    pq.add(new long[]{nextNode, dist[nextNode][nextVisited], nextVisited});
                }
            }
        }

        long answer = dist[N][6]; 
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
		
	}
	

}
