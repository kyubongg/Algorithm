import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 2번 연산
		// 우선순위 1 : 절대값이 작은 수
		// 우선순위 2 : 절대값이 같은 수 중 가장 작은 수
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				Comparator.comparingInt((Integer i) -> Math.abs(i))
				.thenComparingInt(i -> i));
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.add(input);
			}
		}
		
	}
}
