import java.util.Arrays;
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
	static int ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node[] nodes = new Node[E];
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			nodes[i] = new Node(from, to, weight);
		}
		
		p = new int[V+1];
		for(int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		
		Arrays.sort(nodes);
		
		ans = 0;
		for(int i = 0, cnt = 0; cnt < V-1 && i < nodes.length; i++) {
			
			int px = find(nodes[i].from);
			int py = find(nodes[i].to);
			if(px != py) {
				p[py] = px;
				cnt++;
//				System.out.println(Arrays.toString(p));
				ans += nodes[i].weight;
			}
			
			
		}
		
		
		
		System.out.println(ans);
		
		
	}
	
	
	
	static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		
		return p[x];
	}
}
