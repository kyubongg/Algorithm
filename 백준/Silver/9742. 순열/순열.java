import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] factorial = new int[11];
        factorial[0] = 1;
        for (int i = 1; i <= 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        String input;
		while ((input = br.readLine()) != null) {
			
			StringTokenizer st = new StringTokenizer(input);
			
			String word = st.nextToken();
			int targetNum = Integer.parseInt(st.nextToken());
			
			String prefix = word + " " + targetNum + " = ";
			
			if (targetNum > factorial[word.length()]) {
				System.out.println(prefix + "No permutation");
				continue;
			}
			
			List<Character> chars = new ArrayList<>();
			char[] sortedWord = word.toCharArray();
			Arrays.sort(sortedWord);
			
			for (char c : sortedWord) chars.add(c);
			
			StringBuilder result = new StringBuilder();
			int target = targetNum - 1;
			int len = word.length();
			
			for (int i = len; i > 0; i--) {
				int div = factorial[i-1];
				int idx = target / div;
				
				result.append(chars.get(idx));
				chars.remove(idx);
				
				target %= div;
			}
			
			System.out.println(prefix + result.toString());
			
			
		
		}
	}
	
}
