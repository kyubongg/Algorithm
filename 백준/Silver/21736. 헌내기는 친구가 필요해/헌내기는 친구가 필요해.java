import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static String[][] campus;
	static boolean[][] visited;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new String[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			campus[r] = br.readLine().split("");
		}
		
		int startR = 0, startC = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (campus[r][c].equals("I")) {
					startR = r;
					startC = c;
				}
			}
		}
		
		int ans = bfs(startR, startC);
		
		System.out.println(ans == 0 ? "TT" : ans);
	}
	
	static int bfs(int startR, int startC) {
		
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[startR][startC] = true;
		q.add(new int[] {startR, startC});
		
		int meets = 0;
		while (!q.isEmpty()) {
			int[] coord = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = coord[0] + drc[i][0];
				int nc = coord[1] + drc[i][1];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && !campus[nr][nc].equals("X")) {
					if (campus[nr][nc].equals("P")) {
						meets++;
					}
					
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		return meets;
	}
	
	
}
