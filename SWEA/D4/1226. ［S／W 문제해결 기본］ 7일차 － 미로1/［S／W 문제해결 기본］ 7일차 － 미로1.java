import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			
			int N = 16;
			
			int[][] map = new int[N][N];
			
			int startR = 0, startC = 0;
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					int num = str.charAt(j) - '0';
					map[i][j] = num;
					
					// 출발점 찾기
					if(num == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			
			// bfs 돌리기용 큐 만들기
			Queue<int[]> q = new ArrayDeque<>();
			
			// 큐에 출발점 좌표 넣기
			q.add(new int[] {startR, startC});
			
			// 사방탐색할때 상,하,좌,우 r,c 바꾸기
			// 근데 문제에서 방향에 대한 입력이 존재하고, 방향이 1,2,3,4로 정해져 있으면
			// 카운팅 배열처럼 0번 인덱스를 버려야하기 때문에 0번 인덱스에 0을 넣어주고
			// 사방탐색할때 1~4까지 돌아야함(원래는 0~3까지 돔)
//			int[] dr = {0, -1, 1, 0 ,0};
//			int[] dc = {0, 0, 0, -1 ,1};
			
			int[] dr = {-1, 1, 0 ,0};
			int[] dc = {0, 0, -1 ,1};
			
			// 방문처리용 배열
			boolean[][] visited = new boolean[N][N];
			int ans = 0;
			// 큐가 빌때까지 반복 -> 출발점에서 도착점으로 갈 때까지 반복이랑 같은 의미
			while(!q.isEmpty()) {
				// 큐에서 한개 꺼냄(q를 선언할 때 int 배열로 선언해서
				// 꺼낼때도 int 배열로 꺼내야함
				int[] arr = q.poll();
				
				int r = arr[0];
				int c = arr[1];
				visited[r][c] = true;
				
				// 꺼냈을 때 좌표가 도착점이면 ans = 1(도착점에 도달가능)으로 해주고 break;
				// 뒤에는 더이상 할 필요 없으니까 break 해주는 거임
				if(map[r][c] == 3) {
					ans = 1;
					break;
				}
				// arr[0]: row값 들어있음, arr[1]: col값 들어잇음
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					// 영역을 벗어나거나 이미 한번 들렸던곳이면 continue
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					
					// 사방탐색을 했을 때 갈 수 있는 길이면 큐에 넣고, 갈 수 없는 길이면 아무것도 안함
					if(map[nr][nc] == 0 || map[nr][nc] == 3) q.add(new int[] {nr,nc});
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
