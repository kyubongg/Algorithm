import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		q.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		
		int len = 1;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
//			System.out.println(Arrays.toString(curr));
			if(curr[0] == N-1 && curr[1] == M-1) {
				len = curr[2];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(!visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc, curr[2]+1});
				}
			}
			
			
		}
		
		System.out.println(len);
	}
}
