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
			
			// 각 숫자마다 도달할 수 있는 노드 찾기
			for(int k = 1; k < N+1; k++) {
				for(int from = 1; from < N+1; from++) {
					if(dist[from][k] == INF) continue;
					for(int to = 1; to < N+1; to++) {
						if(dist[k][to] == INF) continue;
						dist[from][to] = Math.min(dist[from][to], dist[from][k] + dist[k][to]);
					}
				}
			}
			
			
			// 각 노드별 순위 확인
			// 2차원 배열에 출발, 도착 정보가 있기 땜누에 한 줄씩 읽으면 알 수 있다.
			// 실행 시간은 더 오래걸리네
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				int count = 0;
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					
					if(dist[i][j] != INF || dist[j][i] != INF) count++;
				}
				
				if(count == N-1) {
					ans++;
				}
			}


			
			System.out.println("#" + t + " " + ans);
			
			
		}
	}
}
