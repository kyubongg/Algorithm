import java.util.Scanner;

public class Main {
	
	static int W,H;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = {{-1, -1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			
			if(W == 0 && H == 0) break;
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						ans++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(ans);
		}
		
	}
	
	static void dfs(int r, int c) {
		
		// 팔방탐색
		for(int i = 0; i < 8; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			
			// 영역을 벗어나거나 이미 확인한 곳이면 continue
			if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
			
			if(map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
			
		}
	}
	
	
	
}
