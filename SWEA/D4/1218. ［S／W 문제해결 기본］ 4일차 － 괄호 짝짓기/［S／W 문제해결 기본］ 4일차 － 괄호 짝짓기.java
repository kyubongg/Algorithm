import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			// 입력받는 괄호 문자열의 길이
			int L = sc.nextInt();
			// 입력받는 괄호 문자열
			String str = sc.next();
			// 괄호를 담을 스택
			Stack<Character> stack = new Stack<>();
			// 정답 변수
			int ans = 0;
			
			// 같은 괄호 배열
			boolean isCorrect = true;
			
			// 스택을 이용한다.
			// 1. 여는 괄호면 스택에 넣는다.
			// 2. 닫는 괄호면 스택의 맨 위에 있는 요소와 같은 모양인지 확인
			// 2-1. 같은 모양이면 pop
			// 2-2. 다른 모양이면 return 0;
			// 3. str의 끝까지 갔을 때 스택의 크기가 0이면 return 1;
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				// 여는 괄호일 때 조건
				if(ch == '(' || ch == '{' || ch == '[' || ch == '<') {
					stack.push(ch);
				}else if(ch == ')' || ch == '}' || ch == ']' || ch == '>'){
					// 닫는 괄호일 때 조건
					// 스택의 마지막 값 가져오기
					char recent = stack.peek();
					// 스택의 마지막 값과 닫는 괄호의 모양이 같다면 스택에서 뺀다.
					// 다르다면 올바른 괄호 문자열이 아니기 때문에 반복문을 멈추고 ans를 출력한다.
					if(ch == ')' && recent == '(' || ch == '}' && recent == '{' || ch == ']' && recent =='[' || ch == '>' && recent == '<') {
						stack.pop();
					}else {
						break;
					}
					
//					
				}
				
			}
			
			System.out.println("#" + t + " " + (stack.isEmpty() ? 1 : 0));
		}
		
		sc.close();
	}
}
