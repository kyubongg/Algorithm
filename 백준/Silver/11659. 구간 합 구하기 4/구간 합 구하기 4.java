import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		int[] num = new int[N+1];
		int sum = 0;
		for(int i = 1; i < N+1; i++) {
			sum += sc.nextInt();
			num[i] = sum;
		} 

		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int last = sc.nextInt();
			
			System.out.println(num[last] - num[start-1]);
		}
		
		
		
	}
}
