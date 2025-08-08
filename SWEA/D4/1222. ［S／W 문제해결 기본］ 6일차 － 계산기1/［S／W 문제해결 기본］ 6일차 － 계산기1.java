
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int L = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			int sum = 0;
			
//			for(int i = 0; i < L; i++) {
//				char ch = str.charAt(i);
//				
//				if(Character.isDigit(ch)) {
//					System.out.print(ch);
//				}else {
//					if(stack.isEmpty()) stack.push(ch);
//					else {
//						System.out.print(stack.pop());
//						stack.push(ch);
//					}
//				}
//			}
//			
//			if(!stack.isEmpty()) System.out.print(stack.pop());
			
			String[] strArr = str.split("\\+");
			for(int i = 0; i < strArr.length; i++) {
				sum += Integer.parseInt(strArr[i]);
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}

}
