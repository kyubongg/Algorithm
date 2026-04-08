import java.io.*;
import java.util.*;

public class Main {

	static int MAX = Integer.MIN_VALUE; 
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		List<int[]>[] tree = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			tree[from].add(new int[] {to, dist});
		}
		
		// 두 점 사이의 거리가 가장 먼 값을 구하는것
		// 노드가 최대 1만개, 간선이 최대 9,999개
		// 백트래킹을 해야할 것 같음
		
		// 루트노드가 될 수 있는 애들을 가져와서 좌, 우 
		dfs(tree, 1);
			
		
		System.out.println(MAX);
	}
	
	static int dfs(List<int[]>[] tree, int curr) {
		// 한 부모 노드에 두 자식이 있음
		int firstDist = 0;
		int secondDist = 0;
		
		
		for (int[] next : tree[curr]) {
			int nextNode = next[0];
			int nextDist = next[1];
			
			int maxNextDist = dfs(tree, nextNode) + nextDist;
			
			if (maxNextDist > firstDist) {
				secondDist = firstDist;
				firstDist = maxNextDist;
			} else if (maxNextDist > secondDist) {
				secondDist = maxNextDist;
			}
		}
		
		MAX = Math.max(MAX, firstDist + secondDist);
		
		return firstDist;
	}
}
