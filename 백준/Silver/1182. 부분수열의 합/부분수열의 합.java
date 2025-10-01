import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 비트마스킹하기 위해 정렬함
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for(int i = 0; i < 1 << N; i++) {
			long sum = 0;
			Queue<Integer> q = new LinkedList<>();
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					sum += arr[j];
					q.add(arr[j]);
				}
			}
			
			if(!q.isEmpty() && sum == S) {
//				System.out.println(q);
//				System.out.println("i: " + i);
				cnt++;	
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
		
	}
}
