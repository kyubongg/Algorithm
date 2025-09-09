import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static class Computer implements Comparable<Computer>{
		int from, to, weight;

		public Computer(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Computer o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static int[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();		// 컴퓨터 수
		int M = sc.nextInt();		// 전선 수
		
		Computer[] computers = new Computer[M];
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			computers[i] = new Computer(from, to, weight);
		}
		
		Arrays.sort(computers);
		
		
		p = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		for(int i = 0, cnt = 0; cnt < N-1 && i < computers.length; i++) {
			Computer cp = computers[i];
			
			int px = find(cp.from);
			int py = find(cp.to);
			if(px != py) {
				p[py] = px;
				cnt++;
				ans += cp.weight;
			}
		}
		
//		System.out.println(Arrays.toString(p));
		System.out.println(ans);
	}
	
	
	static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	
	
	
	
	
	
}
