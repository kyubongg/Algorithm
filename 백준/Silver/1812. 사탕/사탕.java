
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// a + b = 5, b + c = 7, c + d = 9, d+a = 7  
		// a + b + c + d = 14   
		
		
		int[] candies = new int[N+1];
		int totalSum = 0;
		for (int i = 0; i < N; i++) {
			int sum = Integer.parseInt(br.readLine());
			totalSum += sum;
			candies[i] = sum;
		}
		
		totalSum /= 2;
		
		int firstStudent = totalSum;
		for (int i = 1; i < N; i += 2) {
			firstStudent -= candies[i];
		}
		
		int curr = firstStudent;
		System.out.println(curr);
		for (int i = 0; i < N - 1; i++) {
			curr = candies[i] - curr;
			System.out.println(curr);
		}
		
		
		
		
		
	}
}
