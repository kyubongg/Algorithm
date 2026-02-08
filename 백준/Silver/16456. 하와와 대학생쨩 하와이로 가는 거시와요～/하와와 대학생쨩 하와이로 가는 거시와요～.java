import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2, -1은 세트임
		int islands = Integer.parseInt(br.readLine());
		long[] dp = new long[Math.max(islands+1, 4)];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		
		
		// i번째 섬으로 가능 방법
		// 1. i-1까지 간 다음 한칸을 간다.
		// 2. i-2까지 간 다음 두칸 가고 -1칸 간다.
		// 3. i-3까지 간 다음 두칸 가고 -1칸 가고 두칸간다.
		for(int i = 4; i <= islands; i++) {
			dp[i] = (dp[i-1] + dp[i-3]) % 1000000009;
		}
		
		System.out.println(dp[islands]);
	}
}
