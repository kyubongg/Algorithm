import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Edge{
		int from, to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
	}
	
	static int V, E;
	static Queue<Integer> q;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			List<Integer>[] edges = new ArrayList[V+1];
			int[] onDegree = new int[V+1];
			
			for(int i = 1; i < V+1; i++) {
				edges[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edges[from].add(to);
				onDegree[to]++;
			}
			
			q = new LinkedList<>();
			
			for(int i = 1; i < V+1; i++) {
				if(onDegree[i] == 0) {
					q.add(i);
				}
			}
			
			System.out.print("#" + t);
			while(!q.isEmpty()) {
				int from = q.poll();
				
				System.out.print(" " + from);
				for(int to : edges[from]) {
					onDegree[to]--;
//					edges[from].remove(to);
					if(onDegree[to] == 0) q.add(to);
					
				}
			}
			System.out.println();
		}
		
		
	}
	
}
