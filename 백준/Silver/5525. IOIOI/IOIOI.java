import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int len = 2 * N + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= len; i++) {
			if (i % 2 != 0) {
				sb.append("I");
			} else {
				sb.append("O");
			}
		}
		
		
		int ans = 0;
		if (M == len) {
			if (S.equals(sb.toString())) ans++; 
		} else {
			for (int i = 0; i < M-sb.length(); i++) {
				String str = S.substring(i, i+len);
				
				if (str.equals(sb.toString())) ans++;
			}
		}
		
		
		System.out.println(ans);
	}
	
	
	
	
	
}
