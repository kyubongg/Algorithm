import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max = 0;
	static boolean[][] visited;
	static int[][] map;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				visited[r][c] = false;
				
				checkT(r, c);
			}
		}

		System.out.println(max);
 	}
	
	static void dfs(int r, int c , int depth, int sum) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs (nr, nc, depth+1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	
	static void checkT(int r, int c) {
		int sum = map[r][c];
	    int wingCount = 0;
	    int minWing = 1001; 

	    for (int i = 0; i < 4; i++) {
	        int nr = r + drc[i][0];
	        int nc = c + drc[i][1];

	        if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
	            wingCount++;
	            sum += map[nr][nc];
	            minWing = Math.min(minWing, map[nr][nc]);
	        }
	    }

	    if (wingCount == 3) {
	        max = Math.max(max, sum);
	    } else if (wingCount == 4) {
	        max = Math.max(max, sum - minWing);
	    }
	}
	
}
