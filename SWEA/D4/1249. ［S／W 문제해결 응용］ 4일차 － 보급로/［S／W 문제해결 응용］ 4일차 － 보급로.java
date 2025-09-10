
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int x, y, sum;

		public Node(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(Node o) {
			return this.sum - o.sum;
		}
		
	}
	
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
				
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			dist[0][0] = 0;
			pq.add(new Node(0, 0, 0));
			
			int time = 0;
			
			int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
					
				if(node.x == N-1 && node.y == N-1) {
					time = node.sum;
					break;
				}
				
				if(node.sum > dist[node.x][node.y]) continue;
				
				for(int i = 0; i < 4; i++) {
					int nr = node.x + drc[i][0];
					int nc = node.y + drc[i][1];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					int newSum = node.sum + map[nr][nc];
					if(newSum < dist[nr][nc]) {
						dist[nr][nc] = newSum;
						pq.add(new Node(nr, nc, newSum));
					}
				}
			}
			
			System.out.println("#" + t + " " + time);
		}
	}

}
