import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int zero;
	static int one;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			
			int result = 1;
			for (int value : map.values()) {
				result *= value+1;
			}
			
			System.out.println(result - 1);
		}
		
	}
	
	
}
