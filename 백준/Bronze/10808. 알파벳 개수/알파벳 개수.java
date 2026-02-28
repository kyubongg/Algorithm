import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int[] alphabets = new int[26];
		for (int i = 0; i < word.length(); i++) {
			alphabets[word.charAt(i) - 'a']++;
		}
        
        for (int cnt : alphabets) {
            System.out.print(cnt + " ");
        }
	}
}
