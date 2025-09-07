

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		Stack<Character> stack = new Stack<>();
		Stack<Character> tmp = new Stack<>();

		for(int j = 0; j < word.length(); j++) {
			stack.push(word.charAt(j));
		}
		
		int cursor = word.length();
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			String command = sc.next();
			
			
			// a b c  cursor : 3
			// a b c  cursor : 1
			// cursor를 stack.size()로 보고
			// 삭제 => size가 cursor-1이 될때까지 스택에 있는거 다뺌 -> 빼고 cursor - 1
			// 추가 => size가 cursor와 같아질 떄까지 스택에 있는거 다뺌 -> 추가해주고 cursor + 1
			switch(command) {
				case "L":
					if(!stack.isEmpty()) tmp.push(stack.pop());
					break;
				case "D":
					if(!tmp.isEmpty()) stack.push(tmp.pop());
					break;
				case "B":
					if(!stack.isEmpty()) stack.pop();
					break;
				case "P":
					char ch = sc.next().charAt(0);
					
					stack.push(ch);

					break;
			}
//			System.out.println(stack);
//			System.out.println(cursor);
//			System.out.println("=====================");
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		StringBuilder sb2 = new StringBuilder();
		while(!tmp.isEmpty()) {
			sb2.append(tmp.pop());
		}
		
		System.out.println(sb.reverse().toString() + sb2.toString());
	}

}
