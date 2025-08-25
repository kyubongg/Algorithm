import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);

		
		
		// 양옆이 0이면 설치
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();	// 도시 개수
			int d = sc.nextInt();	// 차원문 거리 제한
			
			int[] cities = new int[N];
			for(int i = 0; i < N; i++) {
				cities[i] = sc.nextInt();
			}
			
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				if(cities[i] == 0) {
					int cnt = 0;
					for(int j = i; j < i+d; j++) {
						if(j < N && cities[j] == 0) {
							cnt++;
						}
					}
					
					if(cnt == d) {
						cities[i+d-1] = 1;
						ans++;
					}
				}
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
