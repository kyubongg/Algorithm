import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int targetMask = 0;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				targetMask |= (1 << num);
			}
		}
		
		findPassword(0, 0);
		
		System.out.println(answer);
	}
	
	public static void findPassword(int cnt, int currentMask) {
		if (cnt == N) {
			if ((currentMask & targetMask) == targetMask) {
				answer++;
			}
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			findPassword(cnt+1, currentMask | (1 << i));
		}
	}
}
