import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int half = (int) Math.pow(2, N);
		while(half > 1) {
			
			half /= 2;
			
 
			if (r < half && c < half) {			// 1사분면
				
			} else if (r < half && c >= half){	// 2사분면
				ans += (int) Math.pow(half, 2);
				c -= half;
			} else if (r >= half && c < half) {	// 3사분면
				ans += ((int) Math.pow(half, 2) * 2);
				r -= half;
			} else {							// 4사분면
				ans += ((int) Math.pow(half, 2) * 3);
				r -= half;
				c -= half;
			}
		}
		
		System.out.println(ans);
	}
}
