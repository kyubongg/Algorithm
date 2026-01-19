import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 그래프 만들기 (인접 리스트)
		List<Integer>[] friendsArr = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			friendsArr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			friendsArr[a].add(b);
			friendsArr[b].add(a);
		}
		
	
		System.out.println(countInvitedFriends(friendsArr, N));
	}
	
	private static int countInvitedFriends(List<Integer>[] friendsArr, int N) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		
		visited[1] = true;
		queue.offer(1);
		
		int count = 0;
		int depth = 0;
		
		while(!queue.isEmpty() && depth < 2) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int curr = queue.poll();
				
				for(int next : friendsArr[curr]) {
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
						count++;
					}
				}
			}
			
			depth++;
		}
		
		return count;
	}
}
