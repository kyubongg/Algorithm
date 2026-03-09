import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 눈덩이 굴리기 : 위치 +1, 눈덩이 크기 i+1만큼 늘어남
		// 눈덩이 던지기 : 위치 +2, 눈덩이 크기 / 2 + (i+2)만큼 늘어남. 소수점은 절사
		
		int[] snows = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			snows[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][M+1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 1;
		
		int maxSnow = 1;
		for (int t = 1; t <= M; t++) {
			for (int i = 1; i <= N; i++) {
				
				// 굴리기
				int tumble = -1;
				// 던지기
				int throwing = -1;
				
				if (dp[i - 1][t - 1] != -1) {
					dp[i][t] = Math.max(dp[i][t], dp[i - 1][t - 1] + snows[i]);
				}
				
				if (i >= 2 && dp[i - 2][t - 1] != -1) {
					dp[i][t] = Math.max(dp[i][t], (dp[i - 2][t - 1] / 2) + snows[i]);
				}
				
				maxSnow = Math.max(maxSnow, dp[i][t]);
			}
		}
		
		System.out.println(maxSnow);
		
		
 	}
	
}
