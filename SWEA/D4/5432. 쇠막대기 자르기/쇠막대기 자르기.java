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
			
			// 1. "(" 다음 ")"가 나오면 스틱을 자르고 현재 stickStack의 개수만큼 더한다.
			// 2. 만약, 스틱을 자른 다음 ")"가 나오면 sum에 +1을 한다 <- 한 막대기의 끝이기 때문
			for(int i = 0; i < sticks.length(); i++) {
				
				char stick = sticks.charAt(i);
				if(stick == '(') {
					stickStack.push(stick);				// stick이 "("이면 막대기의 개수를 +1 해준다.
				}else {
					stickStack.pop();
					// 2번 조건
					if(sticks.charAt(i-1) == '(') {  	// 현재 stick이 ")"인데, 현재 스틱 -1한 위치의 stick이 "("일때
						sum += stickStack.size();		// stack에 쌓여있는 막대기 개수를 더해준다.
					} 
					else {
						sum += 1;						// 현재 stick이 ")"인데, 현재 스틱 -1한 위치의 stick이 ")"일떄
														// 막대기 한개의 길이가 끝난것이기 때문에 +1을 해준다.
					}
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
        
        sc.close();
	}

}
