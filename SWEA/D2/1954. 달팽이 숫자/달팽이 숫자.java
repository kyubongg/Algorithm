import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int powNum = N * N;
			
			// 상하좌우 값 설정
			int left = 0;
			int right = N-1;
			int top = 0;
			int bottom = N-1;
			int num = 1;
			// 배열 만들기
			int[][] arr = new int[N][N];
			
			while(left <= right && top <= bottom) {
				
				// 오른쪽 이동
				// right까지 이동한 후 top의 위치를 한칸 증가한다.
				for(int col = left; col <= right; col++) {
					arr[top][col] = num++;
				}
				top++;
				
				// 아래쪽 이동
				// bottom까지 이동한 후 right의 위치를 한칸 감소한다.
				for(int row = top; row <= bottom; row++) {
					arr[row][right] = num++;
				}
				right--;
				
				// 왼쪽 이동
				// left가 right보다 작으면 실행해야함.
				// left까지 이동한 후 bottom의 위치를 한칸 감소한다.
				if(left < right) {
					for(int col = right; col >= left; col--) {
						arr[bottom][col] = num++;
					}
					bottom--;
					
				}
				
				// 위쪽 이동
				// top이 bottom보다 작으면 실행해야함
				// top까지 이동한 후 left의 위치를 한칸 증가한다.
				if(top < bottom) {
					for(int row = bottom; row >= top; row--) {
						arr[row][left] = num++;
					}
					left++;
				}
				
				
			}
			
			System.out.println("#" + test_case);
	
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
