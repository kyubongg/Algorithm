import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();		// 저수지 크기
			
			char[][] reservoir = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					reservoir[i][j] = sc.next().charAt(0);
				}
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(reservoir[i][j] == 'W') {
						
						int cnt = 0;
						for(int r = -1; r <= 1; r++) {
							for(int c = -1; c <= 1; c++) {
								if(r == 0 && c == 0) continue;
								int nr = i+r;
								int nc = j+c;
								
								if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
									if(reservoir[nr][nc] == 'W') cnt++;
								}
							}
						}
						
						if(cnt == 0) cnt = 1;
						max = Math.max(max, cnt);
						
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

}
