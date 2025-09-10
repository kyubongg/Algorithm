
import java.util.Scanner;

public class Solution {
	static int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N = 16;
	static int[][] map;
	static int finishR, finishC, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			
			map = new int[N][N];
			
			int startR = 0, startC = 0;
			finishR = 0;
			finishC = 0;
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					int num = str.charAt(j) - '0';
					map[i][j] = num;
					
					if(num == 2) {
						startR = i;
						startC = j;
					}
					if(num == 3) {
						finishR = i;
						finishC = j;
					}
				}
			}
			
			ans = 0;
			dfs(startR, startC);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void dfs(int r, int c) {
		if(ans == 1) return;
		if(r == finishR && c == finishC) {
			ans = 1;
			return;
		}
				
		map[r][c] = 1;
		for(int k = 0; k < 4; k++) {
			int nr = r + drc[k][0];
			int nc = c + drc[k][1];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(map[nr][nc] == 0 || map[nr][nc] == 3) {
//				System.out.println(nr+ " " +nc);
				dfs(nr, nc);
			}
		}

	}
}
