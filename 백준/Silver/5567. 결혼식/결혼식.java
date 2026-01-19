import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static class Friend {
		
		int num, edge;
		
		public Friend(int num, int edge) {
			this.num = num;
			this.edge = edge;
		}
	}
	
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
			String[] friend = br.readLine().split(" ");
			
			int friend1 = Integer.parseInt(friend[0]);
			int friend2 = Integer.parseInt(friend[1]);
			
			friendsArr[friend1].add(friend2);
			friendsArr[friend2].add(friend1);
		}
		
		// 상근이의 학번은 1번이기 때문에 1번부터 그래프 순회
		boolean[] isVisited = new boolean[N+1];
		Queue<Friend> q = new ArrayDeque<>();
		
		q.add(new Friend(1, 0));
		isVisited[1] = true;
	
		int friendsCnt = 0;
		
		
		while(!q.isEmpty()) {
			Friend now = q.poll();
			
			isVisited[now.num] = true;
			
			for(int next : friendsArr[now.num]) {
				
				if(isVisited[next] || now.edge > 1) continue;
				
				isVisited[next] = true;
				friendsCnt++;
				q.add(new Friend(next, now.edge + 1));
			}
			
		}
		
		
		
		System.out.println(friendsCnt);
	}
}
