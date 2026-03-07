import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<Integer> ans;
	static boolean[][] visited, map;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				if (str.charAt(c) == '1') map[r][c] = true;
			}
		}
		
		visited = new boolean[N][N];
		ans = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && map[r][c]) {
					bfs(r, c);
				}
			}
		}
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for (int cnt : ans) {
			System.out.println(cnt);
		}
	}
	
	static void bfs(int r, int c) {
		
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int[] coord = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = coord[0] + drc[i][0];
				int nc = coord[1] + drc[i][1];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc]) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					cnt++;
				}
				
			}
		}
		
		ans.add(cnt);
	}
	
	
	
}
