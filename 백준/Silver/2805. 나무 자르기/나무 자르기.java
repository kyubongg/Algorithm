import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] trees = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			max = Math.max(max, trees[i]);
		}
		
		Arrays.sort(trees);
		
		// 이분탐색 범위 : 0 ~ max-1
		// 최댓값이 max가 되면 M은 무조건 0이 되기 때문에, 문제 조건에 맞지 않음
		int left = 0;
		int right = max;
		int mean = 0;
		while(left <= right) {
			
			mean = (left + right) / 2;
			
			long totalWood = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i] > mean) totalWood += trees[i] - mean;
			}
			
			if(totalWood >= M) {
				left = mean+1;
			}else {
				right = mean-1;
			}
			
		}
		
		System.out.println(right);
		
		sc.close();
	}
}
