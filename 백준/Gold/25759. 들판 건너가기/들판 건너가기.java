
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] flowers = new int[N];
		
		for(int i = 0; i < N; i++) {
			flowers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 앞의 꽃을 땄는지 안땄는지 확인
		int[] dp = new int[101];
		Arrays.fill(dp, -1);
		
		dp[flowers[0]] = 0;
		
		for(int i = 1; i < N; i++) {
			int now = flowers[i];
			
			for(int prev = 1; prev <= 100; prev++) {
				if(dp[prev] != -1) {
					int cost = (int)Math.pow(now - prev, 2);
					dp[now] = Math.max(dp[now], dp[prev] + cost);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[100]);
	}
}
