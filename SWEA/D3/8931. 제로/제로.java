import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			
			Stack<Integer> amounts = new Stack<>();
			
			for(int i = 0; i < K; i++) {
				int amount = sc.nextInt();
				if(amount != 0) {
					amounts.push(amount);
				}else {
					amounts.pop();
				}
			}
			
			int ans = 0;
			for(int i = 0; i < amounts.size(); i++) {
				ans += amounts.get(i);
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}
