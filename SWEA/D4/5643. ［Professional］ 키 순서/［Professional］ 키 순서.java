import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Node{
		int from, to, weight = 1;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		
	}
	
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();		// 학생들의 수
			int M = sc.nextInt();		// 두 학생의 키를 비교한 횧수
			
			int[][] dist = new int[N+1][N+1];

			for(int i = 0; i < N+1; i++) {
				for(int j = 0; j < N+1; j++) {
					if(i != j) dist[i][j] = INF;
				}
			}
			
			for(int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				dist[from][to] = 1;
			}
			
			for(int k = 0; k < N+1; k++) {
				for(int from = 0; from < N+1; from++) {
					if(dist[from][k] == INF) continue;
					for(int to = 0; to < N+1; to++) {
						if(dist[k][to] == INF) continue;
						dist[from][to] = Math.min(dist[from][to], dist[from][k] + dist[k][to]);
					}
				}
			}
			
			List<Integer>[] arr = new ArrayList[N+1];
			
			for(int i = 0; i < N+1; i++) arr[i] = new ArrayList<>();
			
			int ans = 0;
			for(int i = 0; i < dist.length; i++) {
				int cnt = 0;
				for(int j = 1; j < dist[i].length; j++) {
					if(dist[i][j] != 0 && dist[i][j] != INF) {
						// 해당 노드에서 나가서 도달할 수 있는 노드
						arr[i].add(j);
						// 해당 노드로 들어오는 노드
						arr[j].add(i);
					}
				}
			}

			for(List<Integer> list : arr) {
				if(list.size() == N-1) ans++;
			}

			
			System.out.println("#" + t + " " + ans);
			
			
		}
	}
}
