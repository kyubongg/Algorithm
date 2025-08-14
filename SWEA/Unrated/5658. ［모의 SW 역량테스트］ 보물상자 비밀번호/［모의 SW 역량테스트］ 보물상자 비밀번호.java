import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt(); 	// 숫자의 개수
			int K = sc.nextInt()-1;	// 크기 순서
			String str = sc.next();
			// 문자열을 reverse 시키고
			// 큐에 넣은 다음 큐에서 한개 빼고 넣는다.
			Queue<Character> queue = new LinkedList<>(); 
			
			String reversed = new StringBuilder(str).reverse().toString();
			for(int i = 0; i < str.length(); i++) {
				queue.offer(reversed.charAt(i));
			}
			
			
			List<String> passwords = new ArrayList<>();
//			System.out.println(queue.toString());
			for(int i = 0; i < N/4; i++) {
				List<Character> list = new ArrayList<>();
				
				for(int j = queue.size()-1; j >= 0; j--) {
					char ch = queue.poll();
					list.add(ch);
					queue.offer(ch);
				}
				
				
				// 0 ~ 8 3씩 늘리기
				for(int m = list.size() - N/4; m >= 0 ; m -= N/4) {
					String numStr = "";
					// m ~ m+2까지 암호문 만들기
					for(int n = m+N/4-1; n >= m ; n--) {
						numStr += list.get(n);
					}
					if(!passwords.contains(numStr))	passwords.add(numStr);
				}
				
				queue.offer(queue.poll());

			}
			
			// 내림차순 정렬
			Collections.sort(passwords);
			int idx = passwords.size()-1 - K; 
			int num = Integer.parseInt(passwords.get(idx), 16);
			System.out.println("#" + t + " " + num);
		}
		
	}

}
