import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dp;
	static final int INF = 16_000_000;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][1 << N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(tsp(0, 1));
		
	}
	
	static int tsp(int now, int visited) {
		// 모두 방문했음
		if (visited == (1 << N) - 1) {
			
			// 시작점으로 돌아갈 수 없음
			if (map[now][0] == 0) return INF;
			// 돌아갈 수 있다면
			return map[now][0];
		}
		
		
		if (dp[now][visited] != -1) return dp[now][visited];
		
		dp[now][visited] = INF;
		
		for (int next = 0; next < N; next++) {
			
			if (map[now][next] == 0 || (visited & (1 << next)) != 0) continue;
			
			int nextCost = tsp(next, visited | (1 << next));
			
			dp[now][visited] = Math.min(dp[now][visited], map[now][next] + nextCost);
		}
		
		return dp[now][visited];
	}
	
}
