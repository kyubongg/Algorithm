import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int x, y, weight;

		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int idx = 1;
		while(true) {
			
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0, map[0][0]));
			

			int weight = 0;
			int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
			
				if(n.weight > dist[n.x][n.y]) continue;				
				
				if(n.x == N-1 && n.y == N-1) {
					weight = n.weight;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = n.x + dir[i][0];
					int ny = n.y + dir[i][1];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					int newWeight = n.weight + map[nx][ny];
					
					if(newWeight < dist[nx][ny]) {	// if문이 약간 visited 역할인듯
						dist[nx][ny] = newWeight;
						pq.add(new Node(nx, ny, newWeight));
					}
					
					
				}
				
			
			}
			
			System.out.printf("Problem %d: %d\n", idx, weight);
			idx++;
		}
		
	}
}
