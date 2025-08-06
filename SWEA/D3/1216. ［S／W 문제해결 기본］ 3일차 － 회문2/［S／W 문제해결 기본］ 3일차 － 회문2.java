
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			
			int num = sc.nextInt();
			sc.nextLine();
			
			char[][] arr = new char[100][100];
			
			// char형태의 2차원 배열에 값 저장
			for(int i = 0; i < 100; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			// 정답 변수
			int ans = 0;
			
			// 길이가 100부터 1까지
			for(int len = 100; len >= 1; len--) {
				
				// 가로 회문 검사
				row:
				for(int i = 0; i < 100; i++) {
					// len의 길이에 따라 반복 횟수가 달라짐
					for(int j = 0; j <= 100 - len; j++) {
						boolean isPalin = true;
						// len 길이 만큼의 회문 여부 확인
						for(int k = 0; k < len / 2; k++) {
							if(arr[i][j+k] != arr[i][j+len-1-k]) {
								isPalin = false;
								break;
							}
						}
						
						if(isPalin) {
							ans = len;
							break ;
							
						}
						
					}
					if(ans == len) break;
				}
				
				if(ans == len) break;
				
				// 세로 회문 검사
				
				for(int i = 0; i < 100; i++) {
					for(int j = 0; j <= 100 - len; j++) {
						boolean isPalin = true;
						// len 길이 만큼의 회문 여부 확인
						for(int k = 0; k < len / 2; k++) {
							if(arr[j+k][i] != arr[j+len-1-k][i]) {
								isPalin = false;
								break;
							}
						}
						
						if(isPalin) {
							ans = len;
							break;
						}
						
						
					}
					if(ans == len) break;
					
				}
				if(ans == len) break;
				
			}
			
			
			System.out.println("#" + num + " " + ans);
		}
	}

}
