import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[10];
		for(int i = 0; i < 10; i++) {
			scores[i] = sc.nextInt();
		}
 
		int sum = 0;
		int diff = Integer.MAX_VALUE;
		int ans = 0;
		
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
			
			if(diff >= Math.abs(100 - sum)) {
				ans = sum;
				diff = Math.abs(100 - sum);
			}
			else break;
			
		}
		
		
		System.out.println(ans);
		
	}

}
