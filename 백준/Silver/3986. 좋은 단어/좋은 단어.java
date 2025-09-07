import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int tc = sc.nextInt();
		int ans = 0;
		for(int t = 1; t <= tc; t++) {
			
			Stack<Character> stack = new Stack<>();
			String word = sc.next();
			
			for(int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				
				if(stack.isEmpty()) stack.push(ch);
				else {
					if(stack.peek() == ch) stack.pop();
					else stack.push(ch);
				}
				
			}
			
			
			if(stack.isEmpty()) ans++;
		}
		
		System.out.println(ans);
		
	}

}
