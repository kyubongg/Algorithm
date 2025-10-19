import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node{
		// curr: 현재 위치, cnt: 이동 횟수
		int curr, cnt;

		public Node(int curr, int cnt) {
			this.curr = curr;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [curr=" + curr + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	static int max = 100000;
	static int min = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		
		Queue<Node> nodes = new ArrayDeque<>();
		nodes.add(new Node(N, 0));
		
		int num = 0;
		while(true) {
			Node node = nodes.poll();
			
			if(node.curr == K) {
				System.out.println(node.cnt);
				break;
			}
			
			int plus = node.curr + 1;
			int minus = node.curr - 1;
			int twice = node.curr * 2;
			
			if(plus <= max && !visited[plus]) {
				visited[plus] = true;
				nodes.add(new Node(plus, node.cnt + 1));
			}
			if(minus >= min && !visited[minus]) {
				visited[minus] = true;
				nodes.add(new Node(minus, node.cnt + 1));
			}
			if(twice > min && twice <= max && !visited[twice]) {
				visited[twice] = true;
				nodes.add(new Node(twice, node.cnt + 1));
			}
				
		}
		
		sc.close();
		
	}
}
