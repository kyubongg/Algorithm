import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// 몇번 반복할지 세기 위한 변수
		int maxHeight = 0;
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = sc.nextInt();
				
				map[i][j] = num;
				maxHeight = Math.max(maxHeight, num);
			}
		}
		
		// 비가 오지 않으면 영역이 1개임
		int maxArea = 1;
		for(int height = 1; height < maxHeight; height++) {
			maxArea = Math.max(maxArea, bfs(height));
		}
		
		System.out.println(maxArea);
		
		sc.close();
	}
	
	static int bfs(int height) {
		
		int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		// 매 반복마다 큐와 방문배열 초기화
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		// 영역의 개수를 반환하기 위한 변수
		int area = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// map을 돌다가 방문하지 않고, 높이보다 큰 값인 곳을 찾으면 시작
				// 반복횟수를 줄이기 위해서 이렇게 함
				if(!visited[r][c] && map[r][c] > height) {
					
					q.add(new int[] {r, c});
					visited[r][c] = true;
					
					while(!q.isEmpty()) {
						int[] now = q.poll();
						
						
						
						for(int i = 0; i < 4; i++) {
							int nr = now[0] + drc[i][0];
							int nc = now[1] + drc[i][1];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= height) continue;
							
							q.add(new int[] {nr, nc});
							visited[nr][nc] = true;
							
						}
					}
					
					area++;
				}
			}
		}
		
		return area;
	}
	
	
	
}
