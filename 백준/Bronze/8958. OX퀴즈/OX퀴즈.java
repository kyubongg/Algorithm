import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();	// 테스트케이스 개수
		
		for(int t = 0; t < tc; t++) {
			Stack<Character> stack = new Stack<>();
			
			String str = sc.next();
			
			for(int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}
			

			int score = 0;
			int sum = 0;
			while(!stack.isEmpty()) {
				
				if(stack.peek() == 'O') {
					score++;
					stack.pop();
					sum += score;
					
					
				}else {
					score = 0;
					stack.pop();
				}

			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}

}
