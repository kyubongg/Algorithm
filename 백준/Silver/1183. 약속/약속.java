import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] diffs = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int firstNum = Integer.parseInt(st.nextToken());
			int secondNum = Integer.parseInt(st.nextToken());
			
			diffs[i] = secondNum - firstNum;
		}
		
		
		if(N % 2 != 0) {
			System.out.println(1);
		} else {
			Arrays.sort(diffs);
			
			int ans = diffs[N/2] - diffs[N/2 -1] + 1;
			System.out.println(ans);
		}
		
		
	}
}
