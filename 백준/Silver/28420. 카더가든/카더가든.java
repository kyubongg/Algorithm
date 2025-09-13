import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 시간복잡도 : O(NM)
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int A = sc.nextInt();	// 차와 캠핑카의 너비
		int B = sc.nextInt();	// 차의 길이
		int C = sc.nextInt();	// 캠핑카의 길이
		
		int[][] map = new int[N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		boolean possible = true;
		// "--" 모양 : col - (b+c), row - a
		int min1 = Integer.MAX_VALUE;
		for(int i = 0; i <= N - A; i++) {
			for(int j = 0; j <= M -(B+C); j++) {
				int sum1 = 0;
				possible = true;
				label:
				for(int r = i; r < i+A; r++) {
					for(int c = j; c < j+(B+C); c++) {
						sum1 += map[r][c];
						
						if(sum1 > min1) {
							possible = false;
							break label;
						}
					}
				}
				
				if(possible) min1 = sum1;
			}
		}
		// 차가 밑에 있는 "ㄱ" 모양 : col - (A+C), row - (A+B)
		int min2 = Integer.MAX_VALUE;
		for(int i = 0; i <= N - (A+B); i++) {
			for(int j = 0; j <= M -(A+C); j++) {
				int sum2 = 0;
				possible = true;
				// 캠핑카 영역
				label:
				for(int r = i; r < i+A; r++) {
					for(int c = j; c < j+C; c++) {
						sum2 += map[r][c];
						
						if(sum2 > min2) {
							possible = false;
							break label;
						}
					}
				}
				// 차 영역
				label:
				for(int r = i+A; r < i+(A+B); r++) {
					for(int c = j+C; c < j+(C+A); c++) {
						sum2 += map[r][c];
						if(sum2 > min2) {
							possible = false;
							break;
						}
					}
				}
				
				if(possible) min2 = sum2;
			}
		}
		
		// 차가 위에 있는 "ㄱ" 모양 : col - (A+B), row - (A+C)
		int min3 = Integer.MAX_VALUE;
		for(int i = 0; i <= N - (A+C); i++) {
			for(int j = 0; j <= M -(A+B); j++) {
				int sum3 = 0;
				possible = true;
				// 캠핑카 영역
				label:
				for(int r = i+A; r < i+(A+C); r++) {
					for(int c = j+B; c < j+(B+A); c++) {
						sum3 += map[r][c];
						
						if(sum3 > min3) {
							possible = false;
							break label;
						}
					}
				}
				// 차 영역
				label:
				for(int r = i; r < i+A; r++) {
					for(int c = j; c < j+B; c++) {
						sum3 += map[r][c];
						if(sum3 > min3) {
							possible = false;
							break;
						}
					}
				}
				
				if(possible) min3 = sum3;
			}
		}

		
		int min = Math.min(min1, Math.min(min2, min3));
		System.out.println(min);
	}
}
