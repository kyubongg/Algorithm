import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 투포인터로 풀 예정
		// 1. 두 숫자 사이의 최대값/최소값의 차가 2이하면 right 한칸 전진
		// 2. 2보다 커지면 현재 길이를 최대 길이 변수와 비교해서 최대길이 저장
		// 	2.1. 최소값이 사라질 때 까지 left 이동
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int[] cnt = new int[11];
		int maxLen = 0;
		
		while(right < N) {
			
			cnt[num[right]]++;
			
			while (getDiff(cnt) > 2) {
				cnt[num[left]]--;
				left++;
			}
			
			maxLen = Math.max(right - left + 1, maxLen);
			right++;
			
		}
		
		System.out.println(maxLen);
		
 	}
	
	static int getDiff(int[] cnt) {
		int max = 1, min = 10;
		for (int i = 1; i <= 10; i++) {
			if (cnt[i] > 0) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}
		
		return max - min;
	}
	
}
