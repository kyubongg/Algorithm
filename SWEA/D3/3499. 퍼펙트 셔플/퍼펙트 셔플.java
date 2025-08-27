import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			
			
			// 큐를 두개 만들어서 하나씩 빼온다
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			int length = sc.nextInt();
			
			for(int i = 1; i <= length; i++) {
				if(length%2 != 0) {
					if(i <= length/2 + 1) queue1.add(sc.next());
					else queue2.add(sc.next());
				}else {
					if(i <= length/2) queue1.add(sc.next());
					else queue2.add(sc.next());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 1; i <= length; i++) {
				if(i%2 != 0) sb.append(queue1.poll());
				else sb.append(queue2.poll());
				sb.append(" ");
			}
			
			System.out.println("#" + t + " " + sb.toString());
			
		}
		
		
		

	}

}
