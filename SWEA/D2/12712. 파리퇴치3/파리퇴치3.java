import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();	// 배열 크기
			int M = sc.nextInt();	// 스프레이 세기
			
			int[][] flies = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			
			// 상 하 좌 우
			int[][] plusDrc = {{-1,0}, {1,0}, {0,-1}, {0,1}};
			int[][] xDrc = {{-1,-1}, {-1, 1}, {1, -1}, {1, 1}};
			
			int max = 0;
			// 전체 영역을 돌아 다님
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = 0;
					sum += flies[i][j];
					// + 방향
					for(int m = 1; m < M; m++) {
						for(int k = 0; k < 4; k++) {
							int nr = i + m * plusDrc[k][0];
							int nc = j + m * plusDrc[k][1];
							
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
								sum += flies[nr][nc];

							}
							
						}
						
					}

					max = Math.max(max, sum);
					
					sum = 0;
					sum += flies[i][j];
					// x 방향
					for(int m = 1; m < M; m++) {
						for(int k = 0; k < 4; k++) {
							int nr = i + m * xDrc[k][0];
							int nc = j + m * xDrc[k][1];
							
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
								sum += flies[nr][nc];
							}
						}
					}
					
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

}
