import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 사람 수
		
		int[] times = new int[N+1];
	
		for(int i = 1; i <= N; i++) {
			times[i] = sc.nextInt();
		}
		
		Arrays.sort(times);
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = i; j >= 1; j--) {
				sum += times[j];
			}
		}
		
		System.out.println(sum);
	}
}
