import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		
		int[] S = new int[tc];
		int[] B = new int[tc];
		
		for(int t = 0; t < tc; t++) {
			S[t] = sc.nextInt();
			B[t] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < (1 << tc); i++) {
			
			int s = 1;
			int b = 0;
			for(int j = 0; j < tc; j++) {
				if((i & (1<<j)) != 0) {
					s *= S[j];
					b += B[j];
				}
			}
			
			min = Math.min(min, Math.abs(s - b));
			
		}
		
		System.out.println(min);
		sc.close();
	}
}
