import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int len = sc.nextInt();
		String num = sc.next();
		Stack<Character> stack = new Stack<>();
		
		int cnt = 0;
		for(int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			
			if(stack.isEmpty()) stack.push(ch);
			else {
				while(!stack.isEmpty() && cnt < len && stack.peek() < ch) {
					stack.pop();
					cnt++;
//					System.out.println(stack);
				}
				stack.push(ch);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(stack.size() != (N-len)) {
			int size = stack.size();
			for(int i = 0; i < size - (N-len); i++) {
				stack.pop();
				
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
	}
}
