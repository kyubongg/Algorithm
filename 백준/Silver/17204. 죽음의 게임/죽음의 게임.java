import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// 자기 자신을 지목하는 경우도 있음 <- 중요!!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// i번 사람이 가리키는 사람의 번호를 저장할 배열 : players
		int[] players = new int[N];
		
		for (int player = 0; player < N; player++) {
			players[player] = Integer.parseInt(br.readLine());
		}

		boolean[] visited = new boolean[N];
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(0);
		visited[0] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int nowPlayer = q.poll();
			int nextPlayer = players[nowPlayer];
			cnt++;
			
			if (visited[nextPlayer]) {
				System.out.println(-1);
				break;
			}
			
			if (nextPlayer == K) {
				System.out.println(cnt);
				break;
			}
			
			visited[nextPlayer] = true;
			q.add(nextPlayer);
		}
	}

}
