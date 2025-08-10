import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 카드의 개수
		int M = sc.nextInt();		// 목표 값
		
		int[] cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int ans = 0;
		
		// N장의 카드 중 3장을 골라서 M과 최대한 가까운 값을 찾아야함
		// N개중에 중복없이 3개를 뽑는 조합 
		for(int i = 0; i < N - 2; i++) {
			for(int j = i+1; j < N - 1; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(M - sum < 0) continue;
					if(M - sum < min) {
						min = Math.abs(M - sum);
						ans = sum;
					}
				}
			}
		}
		
		
		System.out.println(ans);
		
		
	}

}
