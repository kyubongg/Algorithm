import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 세로 크기
		int M = sc.nextInt();	// 가로 크기
		
		// 주사위 시작 위치
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int K = sc.nextInt();	// 명령의 개수
		
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] keywords = new int[K];
		for(int i = 0; i < K; i++) {
			keywords[i] = sc.nextInt();
		}
		
		/**
		 * 주사위 모양
		 *   2
		 * 4 1 3
		 *   5
		 *   6
		 *   
		 * 1: 2,3,4,5
		 * 2: 1,3,4,6
		 * 3: 1,2,5,6
		 * 4: 1,2,5,6
		 * 5: 1,3,4,6
		 * 6: 2,3,4,5
		 * 
		 * 서로 마주보는 면: 1-6, 2-5, 3-4
		 */
		int[][] drc = {{0,1}, {0,-1}, {-1, 0}, {1, 0}};
		// 주사위 처음 놓인 모양: 위(1), 동쪽(3)
		
		// 위, 아래, 동, 서, 북, 남
		int[] dice = new int[6];
		
		for(int i = 0; i < K; i++) {
			int keyword = keywords[i];
			
			int nx = x + drc[keyword-1][0];
			int ny = y + drc[keyword-1][1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
		        continue; 
		    }
			
			x = nx;
			y = ny;
			
			int temp = dice[0];
			switch(keyword) {
				
				// 동쪽 이동
				case 1:
					dice[0] = dice[3];
					dice[3] = dice[1];
					dice[1] = dice[2];
					dice[2] = temp;
					break;
					
				// 서쪽 이동
				case 2:
					dice[0] = dice[2];
					dice[2] = dice[1];
					dice[1] = dice[3];
					dice[3] = temp;
					break;
					
				// 북쪽 이동
				case 3:
					dice[0] = dice[5];
					dice[5] = dice[1];
					dice[1] = dice[4];
					dice[4] = temp;
					break;
					
					
				// 남쪽 이동
				case 4:
					dice[0] = dice[4];
					dice[4] = dice[1];
					dice[1] = dice[5];
					dice[5] = temp;
					break;
					
 			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[1];
			}else  {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}
			
			
			
			System.out.println(dice[0]);
				
			
		}

		sc.close();
	}
}
