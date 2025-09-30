import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Ballon{
		int index, value;
		
		public Ballon(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayDeque<Ballon> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			deque.add(new Ballon(i, sc.nextInt()));
		}
		
		
		StringBuilder sb = new StringBuilder();
		// 이전에 뽑은 풍선이 양수인지 음수인지
		boolean flag = false;
		Ballon ballon = null;
		while(!deque.isEmpty()) {
			
			
			ballon = deque.pollFirst();
			
			sb.append(ballon.index + " ");
			
			if(deque.isEmpty()) break;
			
			int value = ballon.value;
			// 오른쪽으로 이동
			if(value > 0) {
				for(int i = 0; i < value-1; i++) {
					deque.addLast(deque.pollFirst());
				}
			}else {
				for(int i = 0; i < Math.abs(value); i++) {
					deque.addFirst(deque.pollLast());
				}
			}
			
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}

