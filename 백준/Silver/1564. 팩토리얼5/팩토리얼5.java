import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long result = 1;
		long mod = 1_000_000_000_000L;
		
		for(int i = 2; i <= N; i++) {
			
			result *= i;
			
			while(result % 10 == 0) {
				result /= 10;
			}
			
			result %= mod;
		}
		
		System.out.printf("%05d\n", result % 100000);
		sc.close();
	}
}
