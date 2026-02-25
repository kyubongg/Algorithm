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
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] prefix = new int[N];
		
		prefix[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
		if (N == K) {
			System.out.println(prefix[N-1]);
		} else {
			int max = prefix[K-1];
			for (int i = 1; i <= N-K; i++) {
				int sum = prefix[K+i-1] - prefix[i-1];
				max = Math.max(max, sum);
			}
			
			System.out.println(max);
		}
		
		
		
		
	}
}
