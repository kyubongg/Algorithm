import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int[] parent;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] T = new int[N+1];	// 각 방에 비상탈출구를 설치하는데 드는 시간
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			pq.add(new Edge(from, to, cost));

		}
		
		// 0번 노드는 없기 때문에, 탈출구를 0으로 가정
		for(int i = 1; i < N+1; i++) {
			int exit = sc.nextInt();
			pq.add(new Edge(i, 0, exit));
		}

		parent = new int[N+1];
		for(int i = 0; i < N+1; i++) parent[i] = i;
		
		int totalCost = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			if(cnt == N) break;
			
			Edge curr = pq.poll();
			
			if(findP(curr.from) != findP(curr.to)) {
				union(curr.from, curr.to);
				totalCost += curr.cost;
				cnt++;
			}
		}
		
		System.out.println(totalCost);


	}
	
	static int findP(int num) {
		if(num != parent[num]) {
			parent[num] = findP(parent[num]);
		}
		
		return parent[num];
	}
	
	static void union(int a, int b) {
		int rootA = findP(a);
		int rootB = findP(b);
		if(rootA != rootB) parent[rootB] = rootA;
	}

}
