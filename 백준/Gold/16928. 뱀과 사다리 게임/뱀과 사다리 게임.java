import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Player {
		int space, turn;
		
		public Player(int space, int turn) {
			this.space = space;
			this.turn = turn;
		}
	}
	
	static int N, M;
	static int[] spaces;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		spaces = new int[101];
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			
			spaces[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
		}
		
		System.out.println(getTurn());
 	}

	static int getTurn() {
		
		Queue<Player> q = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		
		// 시작점 1
		q.add(new Player(1, 0));
		visited[1] = true;
		
		Player p;
		int maxSpace = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Player curr = q.poll();
			
			if (curr.space == 100) {
				return curr.turn;
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = curr.space + i;
				
				if (next > 100) continue;
				
				if (spaces[next] != 0) {
					next = spaces[next];
				}
				
				if (!visited[next]) {
					q.add(new Player(next, curr.turn + 1));
					visited[next] = true;
				}
			}
			
		}
		
		return -1;
	}	
	
	
	
	
}
