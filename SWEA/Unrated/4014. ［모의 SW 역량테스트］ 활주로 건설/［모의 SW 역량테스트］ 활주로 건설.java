
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int X;
	static int ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			
			int[][] rowArr = new int[N][N];
			int[][] colArr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int num = sc.nextInt();
					rowArr[i][j] = num;
					colArr[j][i] = num;
				}
			}
			
//			System.out.println(Arrays.deepToString(colArr));
			ans = 0;
			
			// 가로 탐색
			check(rowArr);
			check(colArr);
			
			System.out.println("#" + t + " " + ans);
			
			
			// 세로 탐색
		}
	}
	
	static void check(int[][] arr) {
		// 현재 값과 다음값이 다를때
		// 1. 현재 값 < 다음 값
		// 1.1. 현재 인덱스 ~ 다음 값 인덱스-X까지 +1 => 다음 값이랑 전부 똑같은지 비교
		// 2. 현재 값 > 다음 값
		// 2.1. 다음 값 인덱스 ~ 현재값 인덱스+X까지 +1 => 현재 값이랑 전부 똑같은지 비교
		
		for(int i = 0; i < N; i++) {
			int[] row = arr[i];
			boolean[] isSlope = new boolean[N];
			boolean isPossible = true;
			
			for(int j = 0; j < N - 1; j++) {
				int diff = row[j] - row[j+1];
				
				if(Math.abs(diff) > 1) {
					isPossible = false;
					break;
				}
				
				if(diff == 0) {
					continue;
				}
				
				// 1. 내리막 경사로
				if(diff == 1) {
					for(int k = 1; k <= X; k++) {
						if(j+k >= N || row[j+1] != row[j+k] || isSlope[j + k]) {
							isPossible = false;
							break;
						}
					}
					
					if(isPossible) {
						for(int k = 1; k <= X; k++) {
							isSlope[j+k] = true;
						}
					}
				}
				
				// 2. 오르막 경사로
				else if(diff == -1) {
					for(int k = 0; k < X; k++) {
						if(j-k < 0 || row[j] != row[j-k] || isSlope[j-k]) {
							isPossible = false;
							break;
						}
					}
					
					if(isPossible) {
						for(int k = 0; k < X; k++) {
							isSlope[j-k] = true;
						}
					}
				}
				
				if(!isPossible) break;
			}
			
			

			if(isPossible) ans++;
		}
	}
}
