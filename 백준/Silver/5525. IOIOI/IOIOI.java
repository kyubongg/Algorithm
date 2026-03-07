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
			for (int i = 0; i < M - len; i++) {
				boolean flag = true;
				for (int j = i; j < i + len; j++) {
					if (sb.charAt(j-i) != S.charAt(j) && S.charAt(j) == 'O') {
						flag = false;
						int cnt = 1;
						while (true) {
							if (S.charAt(j+cnt) == 'I') {
								break;
							}
							cnt++;
						}
						i += cnt-1;
						break;
					}
					
					if (sb.charAt(j-i) != S.charAt(j) && S.charAt(j) == 'I') {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					ans++;
				}
			}
		}
		
		
		System.out.println(ans);
	}
	
	
	
	
	
}
