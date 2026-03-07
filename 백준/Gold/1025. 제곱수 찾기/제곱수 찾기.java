import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static int[][] drc = {
			{-1, -1}, {-1, 0}, {-1, 1},
			{0, -1}, {0, 1},
			{1, -1}, {1, 0}, {1, 1}
	};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		for (int r = 0; r < R; r++) {
			String input = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = input.charAt(c) - '0';
			}
		}
		
		// 8방향 탐색
		// 등차수열로 진행함
		int max = -1;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				for (int dr = -R; dr < R; dr++) {
					for (int dc = -C; dc < C; dc++) {
						
						if (dr == 0 && dc == 0) continue;
						
						StringBuilder sb = new StringBuilder();
						int nr = r;
						int nc = c;
						
						
						while (nr >= 0 && nr < R && nc >= 0 && nc < C) {
							sb.append(map[nr][nc]);
							
							int num = Integer.parseInt(sb.toString());
							if (Math.sqrt(num) % 1 == 0) {
								max = Math.max(max, num);
							}
							
							nr += dr;
							nc += dc;
						}
					}
				
					
				}
			}
		}
		
		System.out.println(max);
		
		
	}
	
}
