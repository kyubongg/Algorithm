import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			int minVal = 4;
			
			for (int j = 1; j * j <= i; j++) {
				minVal = Math.min(minVal, dp[i - j * j]);
			}
			
			dp[i] = minVal + 1;
		}
		
		System.out.println(dp[N]);
		
	}
	
	
	
	
}
