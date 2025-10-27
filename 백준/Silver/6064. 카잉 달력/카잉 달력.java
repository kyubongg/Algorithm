import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 두 숫자의 최대값이 같으면 같은 숫자 조합만 나올 수 있음
			// ex) 1 1 / 2 2 / 5 5
			if(M == N) {
				if(x == y) System.out.println(x);
				else System.out.println(-1);
			}else {
				
				// M,N 중 작은 숫자를 고정
				// 두 수의 차만큼 큰 숫자에서 뺌(원 순열처럼 숫자가 순환함)
				// 1 ~ 큰수 범위에서 더이상 나올 수가 없을 때까지 반복
				// 원하는 수가 나오면 반복횟수 * 작은 수 + 고정한 수 반환
				int cnt = 0;
				/*
				 * 3 3
				 * 3 1
				 * 3 11
				 * 3 9
				 */
				if(M < N) {
					// x 고정
					int diff = N - M;
					
					boolean[] visited = new boolean[N+1];
					int num = x;
					
					while(!visited[num]) {
						visited[num] = true;
						
						if(num == y) break;
						if(num - diff <= 0) {
							num = num - diff + N;
						}else {
							num -= diff;
						}
						
						cnt++;
					}
					
					if(!visited[y]) System.out.println(-1);
					else System.out.println(cnt * M + x);
					
				}
                /*
			     * 6 6
			     * 4 6
			     * 2 6
			     * 13 6
			     * 11 6
			     * 9 6
			     * 7 6
			     * 5 6
			     */
                else {
					// y 고정
					int diff = M - N;
					
					boolean[] visited = new boolean[M+1];
					int num = y;
					
					while(!visited[num]) {
						
						visited[num] = true;
						
						if(num == x) break;
						if(num - diff <= 0) {
							num = num - diff + M;
						}else {
							num -= diff;
						}
						
						cnt++;
					}
					
					if(!visited[x]) System.out.println(-1);
					else System.out.println(cnt * N + y);
					
				}
				
				
				
			}

		}
		
		sc.close();
	}
}
