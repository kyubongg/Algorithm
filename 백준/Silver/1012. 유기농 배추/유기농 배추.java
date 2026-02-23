import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] cabagges;
	static boolean[][] visited;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	static int earthworms;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			cabagges = new boolean[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				cabagges[Y][X] = true;
			}
			
			earthworms = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && cabagges[r][c]) {
						dfs(r, c);
						earthworms++;
					}
				}
			}
			
			System.out.println(earthworms);
		}
	}
	
	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (nr < 0 || nr >= cabagges.length || nc < 0 || nc >= cabagges[0].length || visited[nr][nc]) {
				continue;
			}
			
			if (cabagges[nr][nc]) {
				
				dfs(nr, nc);
			}
			
		}
	}
}
