import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	static int[][] map;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) list.add(new int[] {i, j});
				map[i][j] = num;
			}
		}
		
		System.out.println(bfs(list));
		// 모든 익은 토마토에서 하루가 지날때마다 주변에 있는 토마토 익게 만듬
		
 	}

	static int bfs(List<int[]> list) {
		
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int[] arr : list) {
			q.add(arr);
		}
		
		int day = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			day++;

			for (int s = 0; s < size; s++) {
				int[] curr = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + drc[i][0];
					int nc = curr[1] + drc[i][1];
					
					if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] != -1 && map[nr][nc] != 1) {
						map[nr][nc] = 1;
						q.add(new int[] {nr, nc});
					}
					
				}	
			}
			
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					day = -1;
				}
			}
		}
		
		return day;
	}
}
