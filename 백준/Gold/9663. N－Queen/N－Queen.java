import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, cnt;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		arr = new int[N];
		
		// 한 row와 col에는 한개의 퀸만 존재할 수 있다.
		// 대각선이 문제임
		nQueen(0);
		System.out.println(cnt);
	}

	static void nQueen(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			
			boolean flag = true;
			for (int j = 0; j < depth; j++) {
				if (arr[j] == arr[depth] || Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) {
					flag = false;
					break;
				} 
				
			}
			
			if (flag) {
				nQueen(depth + 1);
			}	
		}
	}
}
