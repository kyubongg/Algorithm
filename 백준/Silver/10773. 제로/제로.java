import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			
			if(num != 0) stack.push(num);
			else {
				stack.pop();
			}
		}
		
		int ans = 0;
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		
		System.out.println(ans);
	}

}
