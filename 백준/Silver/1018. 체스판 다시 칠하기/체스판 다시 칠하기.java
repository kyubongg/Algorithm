import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 바둑판 시작위치 가능 범위
		// 행: 0 ~ N-8, 열: 0 ~ M-8
		
		char[][] arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;

		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				
				char start = arr[i][j];
				int cnt_w_start = 0;
				for(int r = i; r < i+8; r++) {
					for(int c = j; c < j+8; c++) {
						// 시작위치가 W면 
						// 짝수 행의 짝수 열은 W, 홀수 열은 B여야함
						// 홀수 행의 짝수 열은 B, 홀수 열은 W여야함
						if(start == 'W') {
							if(r % 2 == 0) {
								if(c % 2 == 0) {
									if(arr[r][c] != 'W') cnt_w_start++;
								}else {
									if(arr[r][c] != 'B') cnt_w_start++;
								}
							}else {
								if(c % 2 == 0) {
									if(arr[r][c] != 'B') cnt_w_start++;
								}else {
									if(arr[r][c] != 'W') cnt_w_start++;
								}
							}
						}
						// 시작위치가 B면 
						// 짝수 행의 짝수 열은 B, 홀수 열은 W여야함
						// 홀수 행의 짝수 열은 W, 홀수 열은 B여야함
						else {
							if(r % 2 == 0) {
								if(c % 2 == 0) {
									if(arr[r][c] != 'B') cnt_w_start++;
								}else {
									if(arr[r][c] != 'W') cnt_w_start++;
								}
							}else {
								if(c % 2 == 0) {
									if(arr[r][c] != 'W') cnt_w_start++;
								}else {
									if(arr[r][c] != 'B') cnt_w_start++;
								}
							}
						}
					}
				}
				
				int count_b_start = 64 - cnt_w_start;
				min = Math.min(min, Math.min(cnt_w_start, count_b_start));
			}
		}
		
		System.out.println(min);
	}

}
