import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int L, M, N;
	static boolean[][] isVisited;
	static int[][] map;
	static int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int ans;
	static int cnt;
	
	static class Node{
		int r, c, type, idx;
		
		public Node(int r, int c, int type, int idx) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();		// 세로 크기
			M = sc.nextInt();		// 가로 크기
			
			int R = sc.nextInt();		// 맨홀 뚜껑의 세로 위치
			int C = sc.nextInt();		// 맨홀 뚜껑의 가로 위치
			
			L = sc.nextInt();		// 탈출 후 소요된 시간
			
			map = new int[N][M];
			isVisited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 1;
			bfs(R, C, map[R][C]);
			
			System.out.println("#" + t + " " + ans);
		}

		
	}
	
	static void bfs(int r, int c, int type) {
		// 1. 상하좌우
		// 2. 상하
		// 3. 좌우
		// 4. 상우
		// 5. 하우
		// 6. 하좌
		// 7. 상좌	
		
		// 각 번호별 상하좌우에 연결될 수 있는 배관
		// 1 - [2,5,6], [2,4,7], [3,4,5], [3,6,7]
		// 2 - [1,5,6], [1,4,7],  x,       x
		// 3 - x,        x,      [1,4,5], [1,6,7]
		// 4 - [1,2,5,6], x,      x,      [1,3,6,7]
		// 5 - x,    [1,2,4,7],   x,      [1,3,6,7]
		// 6 - x,    [1,2,4,7],  [1,3,4,5],  x
		// 7 - [1,2,5,6], x,     [1,3,4,5], x
		
		
		// 각자 위치 확인하고 갈 수 있으면 가기
		
		Queue<Node> queue = new LinkedList<>();
		
		int idx = 1;
		queue.add(new Node(r, c, type, idx));
		isVisited[r][c] = true;
//		System.out.println(queue.peek().idx);
		
		while(!queue.isEmpty() && queue.peek().idx < L) {
			Node node = queue.poll();
			
			if(node.idx > idx) idx++;
//			System.out.println(node.r + " " + node.c + " " + node.idx);
			// 현재값 기준 상 하 좌 우의 타입을 가져옴
			
			for(int i = 0; i < 4; i++) {
				int nr = node.r + drc[i][0];
				int nc = node.c + drc[i][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]) continue;
//				nodes[i] = new Node(nr, nc, map[nr][nc]);
//				System.out.println(L);
				// 상
				up: if(i == 0) {
					
					if(map[nr][nc] == 1 ||map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
						if(node.type == 1 || node.type == 2 || node.type == 4 || node.type == 7) {
//							System.out.println(0);
							queue.add(new Node(nr, nc, map[nr][nc], idx+1));
							isVisited[nr][nc] = true;
							ans++;
						}
					}
					
				}// i == 0
				
				
				// 하
				down: if(i == 1) {
					
					if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
						
						if(node.type == 1 || node.type == 2 || node.type == 5 || node.type == 6) {
//							System.out.println(1);
							queue.add(new Node(nr, nc, map[nr][nc], idx + 1));
							isVisited[nr][nc] = true;
							ans++;
						}
					}
					
				} // i == 1
				
				// 좌
				left: if(i == 2) {
					
					if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
						if(node.type == 1 || node.type == 3 || node.type == 6 || node.type == 7) {
//							System.out.println(2);
							queue.add(new Node(nr, nc, map[nr][nc], idx + 1));
							isVisited[nr][nc] = true;
							ans++;
						}
					}
					
				} // i == 2
				
				// 우
				right: if(i == 3) {
					if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
						if(node.type == 1 || node.type == 3 || node.type == 4 || node.type == 5) {
//							System.out.println(3);
							queue.add(new Node(nr, nc, map[nr][nc], idx + 1));
							isVisited[nr][nc] = true;
							ans++;
						}
					}
					
				}// i == 3
			}// for
			
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
