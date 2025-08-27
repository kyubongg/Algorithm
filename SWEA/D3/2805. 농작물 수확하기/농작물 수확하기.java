import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			
			int[][] farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			for(int i = 0; i <= N/2; i++) {
				
					int top = N / 2 - i;
					int bottom = N / 2 + i;
					
					for(int r = top; r <= bottom; r++) {
						sum += farm[i][r];
					}
			}
			
			int top = 0;
			int bottom = N-1;
			for(int i = N/2 + 1; i < N; i++) {
				
				top++;
				bottom--;
				
				for(int r = top; r <= bottom; r++) {
					sum += farm[i][r];
				}
			
				
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}

}
