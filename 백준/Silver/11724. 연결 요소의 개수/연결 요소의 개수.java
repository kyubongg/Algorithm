import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] nodes = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodes[u].add(v);
			nodes[v].add(u);
		}
		
		System.out.println(bfs(nodes));
		
	}
	
	static int bfs(List<Integer>[] nodes) {
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		int CC = N;
		for (int i = 1; i < N; i++ ) {
			if (!nodes[i].isEmpty()) {
				q.add(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					int node = q.poll();
					
					for (int n : nodes[node]) {
						if (!visited[n]) {
							CC--;
							q.add(n);
							visited[n] = true;
						}
					}
					
				}
				
			}
		}

		return CC;
	}
	
	
}
