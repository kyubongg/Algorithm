import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // A 그룹 입력
        int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		long[] B = new long[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}

		long ans = 1;
		boolean overTenDigits = false;
		long MOD = 1_000_000_000L;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				long common = gcd(A[i], B[j]);
				
				ans *= common;
				
				if(ans >= MOD) {
					overTenDigits = true;
					ans %= MOD;
				}
				
				A[i] /= common;
				B[j] /= common;
			}
		}
		
		if (overTenDigits) {
			System.out.printf("%09d\n", ans);
		} else {
			System.out.println(ans);
		}
		
		
		
	}
	
	public static long gcd(long a, long b) {
		while(b > 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}
}
