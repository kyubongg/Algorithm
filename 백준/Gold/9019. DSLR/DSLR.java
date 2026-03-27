import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		String num, ans;
		
		public Node(String num, String ans) {
			this.num = num;
			this.ans = ans;
		}
	}
	
	static String[] command = {"D", "S", "L", "R"};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// L(R)을 호출하고 바로 다음에 R(L)을 호출하는 경우는 없음
		// 10 미만일때는 L,R 호출할 필요 없음
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int input = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(input, target)).append("\n");
		}
		
		System.out.println(sb.toString());
		
 	}
	
	static String bfs(int input, int target) {
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[10001];
		String[] path = new String[10001];
		
		q.add(input);
		visited[input] = true;
		path[input] = "";
		
		while (!q.isEmpty()) {
			int num = q.poll();
			
			if (num == target) {
				return path[num];
			}
			
			for (int i = 0; i < 4; i++) {
				int calc = DSLR(num, i);
				
				if (!visited[calc]) {
					visited[calc] = true;
					path[calc] = path[num] + command[i];
					q.add(calc);
				}
				
			}
		}
		
		return "";
	}
	
	// D : n을 두배로 바꾼다. 결과 > 9999 => 결과 %= 10000
	// S : n-1을 저장, 0이면 9999 저장
	// L : n의 각 자릿수를 왼편으로 회전, 1234 -> 2341
	// R : n을 오른편으로 회전, 1234 -> 4123
	static int DSLR(int n, int type) {
		
		switch(type) {
			case 0 : return (n * 2) % 10000;
			case 1 : return (n == 0) ? 9999 : n - 1;
			case 2 : return (n % 1000) * 10 + n / 1000;
			case 3 : return (n % 10) * 1000 + n / 10;
		}
		
		return -1;
	}
}
