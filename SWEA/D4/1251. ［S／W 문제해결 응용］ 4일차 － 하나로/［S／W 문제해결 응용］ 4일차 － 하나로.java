import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class Island implements Comparable<Island>{
		int from, to;
		double weight;
		
		public Island(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Island o) {
			return Double.compare(this.weight, o.weight);
		}

		
	}
	
	static int[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();		// 노드의 수
			
			Integer[] X = new Integer[N];
			Integer[] Y = new Integer[N];
			
			for(int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++) {
				Y[i] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			Island[] Islands = new Island[(N*(N-1))/2];
			
			// 섬 두개 사이의 가중치 구하기
			int idx = 0;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					double weight = Math.sqrt(Math.pow((X[i] - X[j]), 2) + Math.pow(Y[i] - Y[j], 2));
					
					Islands[idx++] = new Island(i,j,weight);
				}
			}
			
			Arrays.sort(Islands);
			
			p = new int[N];
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
		
			
			double ans = 0;
			// cnt: 간선의 수(간선의 수가 N-1이 될때까지 실행)
			for(int i = 0, cnt = 0; i < Islands.length && cnt < N-1; i++) {
				
				int px = find(Islands[i].from);
				int py = find(Islands[i].to);
				if(px != py) {
					p[py] = px;
					cnt++;
					ans += Math.pow(Islands[i].weight, 2) * E;
				}

			}
			
			System.out.println("#" + t + " " + Math.round(ans));
			
		}
	}
	
	
	static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	

}
