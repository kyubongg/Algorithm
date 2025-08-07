
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			// 쇠막대기 문자열
			String sticks = sc.next();
			// 쇠막대기 스택
			Stack<Character> stickStack = new Stack<>();
			// 쇠막대기 개수
			int stickNum = 0;
			// 정답 변수
			int sum = 0;
			
			// "(" 다음 ")"가 나오면 스틱을 자르고 현재 스틱의 개수만큼 더한다.
			// 만약, 스틱을 자른 다음 ")"가 나오면 sum에 +1을 한다 <- 한 막대기의 끝이기 때문
			for(int i = 0; i < sticks.length(); i++) {
				
				char stick = sticks.charAt(i);
				if(stick == '(') {
					stickStack.push(stick);
				}else {
					stickStack.pop();
					// 레이저 조건
					if(sticks.charAt(i-1) == '(') {
						sum += stickStack.size();	
					} // 막대기의 끝 조건
					else {
						sum += 1;
					}
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}

}
