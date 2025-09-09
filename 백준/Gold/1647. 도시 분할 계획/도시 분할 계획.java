import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Node[] nodes = new Node[M];
		
		for(int i = 0; i < M; i++) {
			nodes[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		p = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			p[i] = i;
		}
		
		Arrays.sort(nodes);
		
		int min = 0;
		// cnt: 한쪽 집합의 크기
		for(int i = 0, cnt = 0; cnt < N-2 && i < M; i++) {
			
			int px = find(nodes[i].from);
			int py = find(nodes[i].to);
			
			if(px != py) {
				p[py] = px;
				cnt++;
				min += nodes[i].weight;
//				System.out.println(px + " " + py);
//				System.out.println(min);
//				System.out.println(Arrays.toString(p));
			}
			
			
		}
		
		
		System.out.println(min);
	}
	

	// 6-4
	// 1 + 2 + 1+ 2 + 2
//	2-3-1-6-4-5
//	7
	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}	
		return p[x];
	}
	
	
}
