
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long K = sc.nextInt();

		long tmp = 0;
		
		for(int i = 1; i <= N; i++) {
			
			int length = (int) Math.log10(i) + 1;
			
			for(int j = 0; j < length; j++) {
				tmp = (tmp * 10) % K;
			}
			
			tmp = (tmp + i) % K;
			
		}
		
		System.out.println(tmp);
		sc.close();
	}
}
