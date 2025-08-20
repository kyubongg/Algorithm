import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int[][] arr = new int[100][100];
			
			
			// 1. 자석이 N극(1)일 때 내려가야하는데 그 열에 S극(1)이 있으면 교착상태
			// 2. 1번의 반대 상황
			// 3. 교착상태가 발생한 열을 HashSet에 저장(중복 없애기 위해서)
			// 4. HashSet에 저장된 열에 교착상태가 몇개 발생했는지 세기
			
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			boolean[] N = new boolean[100];
			boolean[] S = new boolean[100];
			
			// S와 N이 존재하는 열 찾기
			for(int c = 0; c < 100; c++) {
				for(int r = 0; r < 100; r++) {
					if(arr[r][c] == 1) {
						N[c] = true;
					}
					else if(arr[r][c] == 2) {
						S[c] = true;
					}
				}
			}

			// 교착상태 개수 찾기
			// 교착상태 개수 기준
			// 1. 1:1 => 1개
			// 2. 1:N => 1개
			
			// 빨간색이 나오면 isN = true
			// 마지막 파란색이 나오면 isN = false
			int count = 0;
			
			for(int i = 0; i < 100; i++) {
				boolean isStart = false;
				// S와 N이 동시에 존재하는 열만 탐색
				if(N[i] && S[i]) {
					int col = i;
					for(int r = 0; r < 100; r++) {
						if(arr[r][col] == 1) isStart = true;
						
						if(isStart && arr[r][col] == 2) {
							isStart = false;
							count++;
						}
					
					}
					
					
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
		
	}

}
