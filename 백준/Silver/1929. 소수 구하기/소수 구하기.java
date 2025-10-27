import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		
		boolean[] nums = new boolean[N+1];
		nums[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			
			if(nums[i] == true) continue;
			
			for(int j = i * i; j < nums.length; j = j + i) {
				nums[j] = true;
			}
			
		}
		
		for(int i = M; i <= N; i++) {
			if(!nums[i]) System.out.println(i);
		}
		
		
		sc.close();
	}
}	
