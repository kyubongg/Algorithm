import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		List<Integer>[] nodeList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					nodeList[i].add(j);
				}
			}
		}
		
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			
			dfs(i, i, nodeList, visited, result);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		    	if (j < N-1) sb.append(result[i][j]).append(" ");
		    	else sb.append(result[i][j]);
		    }
		    sb.append("\n");
		}
		System.out.print(sb.toString());
		
 	}
	
	static void dfs(int start, int now, List<Integer>[] nodeList, boolean[] visited, int[][] result) {
		for (int next : nodeList[now]) {
			if (!visited[next]) {
				visited[next] = true;
				result[start][next] = 1;
				dfs(start, next, nodeList, visited, result);
			}
		}
	}
	
}
