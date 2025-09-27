import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] stairs = new int[N+1];
		for(int i = 1; i <= N; i++) stairs[i] = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		if(N == 1) {
			System.out.println(stairs[1]);
            return;
		}
		
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];
		for(int i = 3; i <= N; i++) {
			// 한칸 건너 뛴 경우
			int case1 = dp[i-2] + stairs[i];
			
			// 연속으로 밟은 경우
			int case2 = dp[i-3] + stairs[i-1] + stairs[i];
			
			dp[i] = Math.max(case1, case2);
		
		}
		
		System.out.println(dp[N]);
		
	}
}
