import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		/**
		 * 1 ~ N까지 간다.
		 * 
		 * 1. 입력이 0이면 해당 키의 사람은 본인의 입력에 서있는다.
		 * 2. 입력이 0보다 클때
		 * 2.1. 본인 앞 칸에 남은 수 < 입력 =>입력만큼 밀려남
		 * 2.2. 본인 앞 칸에 남은 수 >= 입력 => 위치 그대로 있기
		 * 
		 */
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] peoples = new int[N];
		
		for (int height = 1; height <= N; height++) {
			int leftCount = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				if (leftCount == 0 && peoples[i] == 0) {
					peoples[i] = height;
					break;
				}
				
				if (peoples[i] == 0)
					leftCount--;
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int p : peoples) {
			sb.append(p).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
