import java.util.Scanner;

public class Solution {
	
	static int V, E;
	static int[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();	
			int m = sc.nextInt();	// 입력으로 주어지는 연산의 개수
			
			// 합집합 : 0으로 표현
			// 같은 집합인지 확인하는 연산: 1로 표현
			
			p = new int[n+1];
			
			// 크기가 1인 집합 만들어주기
			for(int i = 1; i < p.length; i++) {
				p[i] = i;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < m; i++) {
				int type = sc.nextInt();
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if(type == 0) {
					p[findSet(to)] = findSet(from);
				}
				else {
					if(findSet(from) == findSet(to)) sb.append("1");
					else sb.append("0");
					
				}
			}
			
			System.out.println("#" + t + " " + sb.toString());
			
		}
	}
	
	static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}
