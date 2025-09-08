import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] drc = {{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			
			int[][] cheeze = new int[N][N];	
			
			// n일차에 먹을 치즈의 위치를 미리 저장 => 시간복잡도 줄이기
			List<int[]>[] indexs = new ArrayList[101];
			
			for(int i = 1; i <= 100; i++) {
				indexs[i] = new ArrayList<>();
			}
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int num = sc.nextInt();
					cheeze[i][j] = num;
					
					indexs[num].add(new int[] {i, j});
				}
			}
			
			int max = 1;
			
			for(int i = 1; i <= 100; i++) {
				// 덩어리 개수 탐색을 위한 배열
				boolean[][] isVisited = new boolean[N][N];
				
				List<int[]> list = indexs[i];
				
				if(list != null) {
					for(int[] arr : list) {
						// n일차에 먹은 치즈를 0으로 만들어줌
						
//						System.out.println(arr[0] + " " + arr[1]);
						
						
						cheeze[arr[0]][arr[1]] = 0;
						isVisited[arr[0]][arr[1]] = true;
					}
				}
				
				/*
				 * 6 8 0 6 0
				 * 0 0 0 4 6
				 * 6 7 0 0 0
				 * 7 0 5 0 6
				 * 8 9 5 0 7
				 */
				
//				System.out.println(Arrays.deepToString(cheeze));
				int cnt = 0;
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(cheeze[r][c] != 0 && !isVisited[r][c]) {
							int startR = r, startC = c;
							
							Queue<int[]> q = new LinkedList<>();
							q.add(new int[] {r,c});
							isVisited[startR][startC] = true;
							
							while(!q.isEmpty()) {
								int[] arr = q.poll();
								
								for(int j = 0; j < 4; j++) {
									int nr = arr[0] + drc[j][0];
									int nc = arr[1] + drc[j][1];
									
									if(nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc] && cheeze[nr][nc] != 0) {
										q.add(new int[] {nr, nc});
										isVisited[nr][nc] = true;
									}
								}
							}
							cnt++;
							
						}
					}
				}
//				System.out.println("cnt: " + cnt);
				max = Math.max(max, cnt);
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
