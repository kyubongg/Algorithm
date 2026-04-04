import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 그래프 배열
		List<Integer>[] exams = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			exams[i] = new ArrayList<>();
		}
		
		// 진입차수 배열
		int[] degrees = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			exams[from].add(to);
			degrees[to]++;
		}
		
		
		// bfs
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (degrees[i] == 0) {
				q.add(i);
			}
		}
		
		List<Integer> answer = new ArrayList<>();
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			answer.add(curr);
			for (int i = 0; i < exams[curr].size(); i++) {
				int next = exams[curr].get(i);
				
				degrees[next]--;
				if (degrees[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		
	}
	
	
}
