import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean isFinish = false;
	static boolean[][] map;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	static class Node{
		int r, c, dist;
		boolean breakPossible;
		
		public Node(int r, int c, int dist, boolean breakPossible) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.breakPossible = breakPossible;
		}
		
		@Override
		public String toString() {
			return "[r : " + r + ", c : " + c + ", dist: " + dist + ", possible: " + breakPossible + "]";  
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				if (input.charAt(c) == '1') {
					map[r][c] = true;
				}
			}
		}
		
		int min = bfs();
		System.out.println(min);
 	}
	
	static int bfs() {
		// visited[r][c][0] : 벽을 안 부수고 이칸에 온 경우
		// visited[r][c][1] : 벽을 부수고 이칸에 온 경우
		boolean[][][] visited = new boolean[N][M][2];
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(0, 0, 1, true));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			int dist = node.dist;
			boolean breakPossible = node.breakPossible;
			
			if (node.r == N-1 && node.c == M-1) {
				return dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = node.r + drc[i][0];
				int nc = node.c + drc[i][1];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					// 다음 길이 벽으로 막혀 있을 때
					if (map[nr][nc]) {
						// 벽을 한번도 안부순 경우
						if (breakPossible && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							q.add(new Node(nr, nc, dist + 1, false));
						} 
					} 
					// 벽이 없는 경우
					else {
						int wallState = breakPossible ? 0 : 1;
						if (!visited[nr][nc][wallState]) {
							visited[nr][nc][wallState] = true;
							q.add(new Node(nr, nc, dist + 1, breakPossible));
						}
						
					}
				}
			}
			
		}
		
		return -1;
	}
	
}
