import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());		
		
		for (int t = 1; t <= tc; t++) {
			
			String func = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			
			ArrayDeque<String> deque = new ArrayDeque<>();
			
			if (N > 0) {
				String[] inputArr = input.substring(1, input.length()-1).split(",");
				
				for (int i = 0; i < inputArr.length; i++) {
					deque.offer(inputArr[i]);
				}
			}
			// R : 양방향 큐를 사용해서 뒤집기 
			// D : 큐의 첫번째 수 버리기
			
			
			// 리버스 했는지 안했는지 체크하는 boolean : isReverse
			boolean isReverse = false;
			boolean isError = false;
			for (int i = 0; i < func.length(); i++) {
				char ch = func.charAt(i);
				
				if (ch == 'R') {
					isReverse = !isReverse;
					
				} else {
					if (deque.isEmpty()) {
						isError = true;
						break;
					} else {
						if (!isReverse)	deque.pollFirst();
						else deque.pollLast();
					}
				}
			}
			
			if (isError) {
				System.out.println("error");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(isReverse ? deque.pollLast() : deque.pollFirst());
					if (!deque.isEmpty()) {
						sb.append(",");
					}
				}
				
				sb.append("]");
				System.out.println(sb);
				
			}
			
			
		}
	}
}
