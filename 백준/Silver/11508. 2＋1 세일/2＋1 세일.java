import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 묶음의 개수 = N / 3 + 1
		int[] prices = new int[N+1];
		for(int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(prices);
		
		int answer = 0;
		
		int[] sortPrices = new int[N+1];
		for(int i = 1; i <= N; i++) {
			sortPrices[i] = prices[N+1-i];
		}
		
		
		for(int i = 1; i <= N; i++) {
			if(i % 3 != 0) {
				answer += sortPrices[i];
			}
		}
		
		System.out.println(answer);
		
	}
}
