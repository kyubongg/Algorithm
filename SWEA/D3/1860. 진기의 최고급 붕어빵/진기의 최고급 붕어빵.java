import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();		// 손님 수
			int M = sc.nextInt();		// 붕어빵의 K개 만드는데 드는 시간
			int K = sc.nextInt();		// M 시간동안 만들 수 있는 붕어빵의 개수
			
			int[] times = new int[N];	// 손님들이 오는 시간
			
			for(int i = 0; i < N; i++) {
				times[i] = sc.nextInt();
			}
			
			Arrays.sort(times);
			
			
			if(times[0] < M) {
				System.out.println("#" + t + " Impossible");
				continue;
			}
			
			int bread = 0;		// 빵 개수
			int hour = 0;
			boolean isPossible = true;
			for(int i = 0; i < times.length; i++) {
				if(times[i] / M > hour) {
					bread += (times[i] / M - hour) * K;
					hour = times[i] / M;
				}
				
				if(bread == 0) {
					isPossible = false;
					break;
				}else {
					bread--;
				}
			}
			
			if(isPossible) {
				System.out.println("#" + t + " Possible");
			}else {
				System.out.println("#" + t + " Impossible");
			}
		}
	}

}
