import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for (int num = N-1; num >= 1; num--) {
			int sum = num;
			
			String strNum = String.valueOf(num);
			boolean flag = true;
			
			for (int i = 0; i < strNum.length(); i++) {
				int ch = strNum.charAt(i) - '0';
				
				sum += ch;
			}
			
			if (sum == N) {
				ans = num;
			}
		}
		
		System.out.println(ans);
		
		
 	}
	
}
