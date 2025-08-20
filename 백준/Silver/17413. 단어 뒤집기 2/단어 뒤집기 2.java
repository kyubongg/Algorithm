import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		// 1. 공백이나 "<" 만날때까지 스택에 넣는다.
		// 2. 공백이나 "<"을 만나면 꺼낸다.
		// 3. "<"가 나오면 ">"가 나올 때까지 문자열에 더한다.
		
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		boolean isStart = false;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			
			if(ch == '<') {
				isStart = true;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(ch);
			}else if(ch == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(ch);
			}else {
				if(isStart) {
					sb.append(ch);
					if(ch == '>') isStart = false;
				}else {
					stack.push(ch);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		
		System.out.println(sb.toString());
	}

}
