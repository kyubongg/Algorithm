import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int num, depth;
		
		public Node(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	
	static int N, M;
	static List<Integer>[] nodes;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodes[node1].add(node2);
			nodes[node2].add(node1);
		}
		
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			int kb = bfs(i);
			
			if (kb == 1) {
				idx = i;
				break;
			} else {
				if (kb < min) {
					min = kb;
					idx = i;
				}
				
			}
		}
		
		System.out.println(idx);
	}
	
	static int bfs(int start) {
		
		int sum = 0;
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (i == start) continue;
			Arrays.fill(visited, false);
			
			q.add(new Node(start, 0));
			visited[start] = true;
			
			while (!q.isEmpty()) {
				Node node = q.poll();
				
				for (int n : nodes[node.num]) {
					
					if (n == i) {
						sum += node.depth+1;
						q.clear();
						break;
					}
					
					if (!visited[n]) {
						q.add(new Node(n, node.depth+1));
						visited[n] = true;
					}
				}
			}
		} 
		
		
		
		return sum;
	}
	
	
	
}
