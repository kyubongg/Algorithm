import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int dr[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1}, dc[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();		// 행 길이
		N = sc.nextInt();		// 열 길이
		
		map = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 맵에서 1인 숫자를 발견할 때마다 팔방탐색을 시도
		// 재귀함수를 사용함
		
		int ans = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 2;
		
		for(int i = 0; i <= 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] != 1) continue;
			dfs(nr, nc);
		}
	}

}
