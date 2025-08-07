import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();  // N : 퍼즐의 사이즈
			int K = sc.nextInt();  // K : 단어의 길이
			int ans = 0;
			
			int[][] puzzles = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					puzzles[i][j] = sc.nextInt();
				}
			}
			
			// 가로 방향 찾기
			for(int i = 0; i < N; i++) {
				// 1이 반복되는 횟수
				int oneCnt = 0; 
				for(int j = 0; j < N; j++) {
					
					// 1이 반복되는 구간의 개수를 찾아야함
					if(puzzles[i][j] == 1) {
						oneCnt++;
					}else {
						if(oneCnt == K) ans++;
						oneCnt = 0;
					}
					
				}
				if(oneCnt == K) ans++;
			}
			
			// 세로 방향 찾기
			for(int i = 0; i < N; i++) {
				// 1이 반복되는 횟수
				int oneCnt = 0;
				for(int j = 0; j < N; j++) {
					
					// 1이 반복되는 구간의 개수를 찾아야함
					if(puzzles[j][i] == 1) {
						oneCnt++;
					}else {
						if(oneCnt == K) ans++;
						oneCnt = 0;
					}
				}
				
				if(oneCnt == K) ans++;
			}
			
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
