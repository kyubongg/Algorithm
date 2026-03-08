
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static int[][] map;
	static int[][] len;
	static boolean[][] visited;
	static int[][] drc = {{-1, 0}, {0, -1}, {0, 1}, {1,0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		len = new int[R][C];
		visited = new boolean[R][C];
		
		int[] start = new int[3];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int input = Integer.parseInt(st.nextToken());
				
				if (input == 2) {
					start[0] = r;
					start[1] = c;
					start[2] = 0;
 				}
				
				map[r][c] = input;
			}
		}
		
		bfs(start);
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != 2 && map[r][c] != 0 && len[r][c] == 0) {
					len[r][c] = -1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(len[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int[] start) {
		
		
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while (!q.isEmpty()) {
			int[] coord = q.poll();
			
			for (int i = 0 ; i < 4; i++) {
				int nr = coord[0] + drc[i][0];
				int nc = coord[1] + drc[i][1];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 1) {
					q.add(new int[] {nr, nc, coord[2] + 1});
					visited[nr][nc] = true;
					len[nr][nc] = coord[2] + 1;
				}
			}
		}
		
	}
	
}
