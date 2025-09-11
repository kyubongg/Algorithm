import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Node{
		int from, to;

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
			int N = sc.nextInt();
			
			// dist 배열: 각 노드의 연결 상태를 나타냄
			// 배열은 y = x를 기준으로 데칼코마니 형태 
			int[][] dist = new int[N][N];
			List<Node> nodes = new ArrayList<>();
			
			// 모든 간선의 길이가 1이기 때문에 출발점과 도착점만 저장함
			// i == j 인 인덱스와 값이 1인 곳을 제외하고 모두 무한대로 만들어줌
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dist[i][j] = sc.nextInt();
					// 무향이니까
					if(dist[i][j] == 1) {
						nodes.add(new Node(i, j));
					}
					else if(dist[i][j] == 0 && i != j) dist[i][j] = INF;
				}
			}

			
			for(int i = 0 ; i < N; i++) {
				for(int from = 0; from < N; from++) {
					if(dist[from][i] == INF) continue;
					for(int to = 0; to < N; to++) {
						if(dist[i][to] == INF) continue;
						dist[from][to] =  Math.min(dist[from][to], dist[from][i] + dist[i][to]);
					}
				}
			}
//			
//			for(int[] row: dist) {
//				System.out.println(Arrays.toString(row));
//			}
			
			
			int ans = INF;
			for(int i = 0; i < N; i++) {
				int[] row = dist[i];
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += row[j];
					
				}
				
				ans = Math.min(ans, sum);
			}
			
			
			
			
			System.out.println("#" + t + " " + ans);
		}
		
		
	}
}
