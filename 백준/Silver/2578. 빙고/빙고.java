import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] bingoMap = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingoMap[i][j] = sc.nextInt();
			}
		}
		
		// 지워진 줄 개수 
		int cnt = 0;
		int ans = 0;
		boolean[] cols = new boolean[5];
		boolean[] rows = new boolean[5];
		boolean[] diag = new boolean[2];
		// 빙고가 나올때까지 반복 
		while(cnt < 3) {
			
			int input = sc.nextInt();

			num:
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(bingoMap[i][j] == input) {
						bingoMap[i][j] = 0;
						ans++;
						break num;
					}
				}
			}

			// 가로 탐색
			for(int c = 0; c < 5; c++) {
				if(cols[c]) continue;
				int zeroCnt = 0;
				
				for(int r = 0; r < 5; r++) {
					if(bingoMap[r][c] == 0) zeroCnt++;
				}
				if(zeroCnt == 5) {
					cols[c] = true;
					cnt++;
				}
			}
			// 세로 탐색
			for(int r = 0; r < 5; r++) {
				if(rows[r]) continue;
				int zeroCnt = 0;
				
				for(int c = 0; c < 5; c++) {
					if(bingoMap[r][c] == 0) zeroCnt++;
				}
				if(zeroCnt == 5) {
					rows[r] = true;
					cnt++;
				}
			}
			// 대각선 탐색
			if(!diag[0]) {
				int zeroCnt = 0;
				for(int r = 0, c = 0; r < 5 && c < 5; r++, c++) {
					if(bingoMap[r][c] == 0) zeroCnt++;
					if(zeroCnt == 5) {
						diag[0] = true;
						cnt++;
					}
				}
			}
			
			if(!diag[1]) {
				int zeroCnt = 0;
				for(int r = 0, c = 4; r < 5 && c >= 0; r++, c--) {
					if(bingoMap[r][c] == 0) zeroCnt++;
					if(zeroCnt == 5) {
						diag[1] = true;
						cnt++;
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}
