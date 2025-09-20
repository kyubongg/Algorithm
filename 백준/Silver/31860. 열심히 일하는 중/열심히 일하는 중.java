import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 하루에 일 한개 처리
		// 일을 처리한 후 해당 일의 중요도 -> M만큼 감소
		// 일의 중요도가 K 이하 -> 완료된 것으로 간주
		// 오늘 만족감 = 전날 만족감(Y)/2 + 오늘 할 일의 중요도(P)  

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 일의 개수
		int M = sc.nextInt();		// 감소하는 중요도
		int K = sc.nextInt();		// 완료된 것으로 간주하는 중요도
		
		// 중요도가 최대 1000임 -> 카운팅 배열 1001로 생성
		int[] input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int days = 0;
		int[] todos = new int[1001];
		for(int todo : input) {
			todos[todo]++;
		}
		
		// 작업 일수 구하기
		for(int i = 1000; i > K; i--) {
			while(todos[i] > 0) {
				days++;
				todos[i]--;
				if(i-M > K) todos[i-M]++;
			}
		}
		System.out.println(days);
		
		todos = new int[1001];
		for(int todo : input) todos[todo]++;
		
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int prev = 0;
		for(int i = todos.length-1; i > K; i--) {
			if(todos[i] == 0) continue;
			
			int cnt = todos[i];
			while(cnt > 0) {
				cnt--;
				sum = sum / 2 + i;
				sb.append(sum).append("\n");
				if(i-M > K) todos[i-M]++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
