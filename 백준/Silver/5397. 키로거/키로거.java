import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			String str = sc.next();
			for(int i = 0; i <str.length(); i++) {
				char ch = str.charAt(i);
				
				switch(ch) {
					case '<':
						if(!left.isEmpty()) right.push(left.pop());
						break;
					case '>':
						if(!right.isEmpty()) left.push(right.pop());
						break;
					case '-':
						if(!left.isEmpty()) left.pop();
						break;
					default:
						left.push(ch);
						break;
						
				}
				
//				System.out.println("left: " + left);
//				System.out.println("right: " + right);
//				System.out.println("=====================");
			}
			
			StringBuilder leftSb = new StringBuilder();
			StringBuilder rightSb = new StringBuilder();
			
			while(!left.isEmpty()) leftSb.append(left.pop());
			while(!right.isEmpty()) rightSb.append(right.pop());
			
			System.out.println(leftSb.reverse().toString() + rightSb.toString());
		}
	}
}
