import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Edge{
		int from, to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int V = sc.nextInt();
		
		// 무방향 그래프
		List<Integer>[] edges = new ArrayList[E+1];
		for(int i = 1; i <= E; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= V; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			
			edges[to].add(from);
			edges[from].add(to);
		}
		
		// 1번 컴퓨터가 웜 바이러스에 걸림
		boolean[] isVirus = new boolean[E+1];
		
		Queue<Integer> q = new ArrayDeque<>();
		int answer = -1;
		q.add(1);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			if(isVirus[node]) continue;
			
			isVirus[node] = true;
			answer++;
			
			for(int next : edges[node]) {
				if(isVirus[next]) continue;
				
				q.add(next);
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}
