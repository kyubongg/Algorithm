
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);


		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = sc.nextInt();
			int[][] arr = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			// 가로 방향
			// 가로 방향 최대값
			int maxRow = 0;
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if(maxRow < sum) maxRow = sum;
			}
			
			
			// 세로 방향
			int maxCol = 0;
			for(int i = 0; i < 100; i++) {
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if(maxCol < sum) maxCol = sum;
			}
			
			// + 대각선 방향
			// - 대각선 방향
			int maxPlus = 0;
			int maxMinus = 0;
			for(int i = 0; i < 100; i++) {
				maxPlus += arr[i][i];
				maxMinus += arr[99-i][99-i];
			}
			
			int[] maxs = new int[] {maxRow, maxCol, maxPlus, maxMinus};
			
			for(int i = 0; i < maxs.length-1; i++) {
				for(int j = 0; j < maxs.length-1-i; j++) {
					if(maxs[j] > maxs[j+1]) {
						int tmp = maxs[j];
						maxs[j+1] = maxs[j];
						maxs[j] = tmp;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + maxs[maxs.length - 1]);
		}
	}
}
