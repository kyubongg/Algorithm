import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int to, time;

		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
			
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", time=" + time + "]";
		}
		
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();	// 컴퓨터 개수
			int d = sc.nextInt();	// 의존성 개수
			int c = sc.nextInt();	// 해킹당한 컴퓨터 번호
			
			List<Node>[] nodes = new ArrayList[n+1];
			for(int i = 0; i < n+1; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			// 의존성 개수만큼 반복
			for(int i = 0 ; i < d; i++) {
				int to = sc.nextInt();
				int from = sc.nextInt();
				int time = sc.nextInt();
				
				nodes[from].add(new Node(to, time));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[n+1];
			int[] dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			dist[c] = 0;
			pq.add(new Node(c,0));
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(visited[node.to]) continue;
				
//				System.out.println(node);
				visited[node.to] = true;
				
				for(Node N : nodes[node.to]) {
					
					if(!visited[N.to] && dist[N.to] > dist[node.to] + N.time) {
						dist[N.to] = dist[node.to] + N.time;
						pq.add(new Node(N.to, dist[N.to]));
					}
				}
						
			}
			
			int max = 0;
			int cnt = 0;
			for(int num : dist) {
				if(num != Integer.MAX_VALUE) {
					max = Math.max(max, num);
					cnt++;
				}
			}
			
			
			System.out.println(cnt + " " + max);
		}
	}

	
}
