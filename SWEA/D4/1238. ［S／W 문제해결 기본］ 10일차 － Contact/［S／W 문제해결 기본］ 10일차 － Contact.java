import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int from, to, cnt;

		public Node(int from, int to, int cnt) {
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
		
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int startNode = sc.nextInt();
			
			List<Node>[] Nodes = new ArrayList[101];
			
			for(int i = 0; i < 101; i++) {
				Nodes[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				Nodes[from].add(new Node(from, to, 0));
			}
//			
//			for(int i = 0; i < 101; i++) {
//				if(Nodes[i].size() == 0) continue;
//				
//				for(int j = 0; j < Nodes[i].size(); j++) {
//					Node n = Nodes[i].get(j);
//					System.out.println(n.from + " " + n.to);
//				}
//			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.addAll(Nodes[startNode]);
			
			boolean[] visited = new boolean[101];
			visited[startNode] = true;
			int ans = 0;
			int cnt = 0;
			
//			System.out.println("=-===================");
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(visited[node.to]) continue;
//				System.out.println(node.from + " " + node.to + " " + node.cnt);
				
				
				
				if(node.cnt != cnt) {
					cnt = node.cnt;
					ans = node.to;
				}else {
					ans = Math.max(ans, node.to);
				}
				

				visited[node.to] = true;
				
				for(int i = 0; i < Nodes[node.to].size(); i++) {
					Node n = Nodes[node.to].get(i);
					n.cnt = cnt + 1;
					pq.add(n);
				}
			}
			
			
			System.out.println("#" + t + " " + ans);
		
		}
	}
}
