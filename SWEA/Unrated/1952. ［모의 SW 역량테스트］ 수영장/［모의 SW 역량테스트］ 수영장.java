import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static Integer[] plans;
	static int min;
	static int sum;
	static int[] fees = new int[4];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			sum = 0;
			for(int i = 0; i < 4; i++) {
				fees[i] = sc.nextInt();
			}
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < 12; i++) {
				int num = sc.nextInt();
				if(num != 0) list.add(num);
			}
			
			plans = list.toArray(new Integer[list.size()]);
			
//			System.out.println(Arrays.toString(plans));
			// 최소값을 1년치로 설정
			min = fees[3];
			
			dfs(0);
			
			System.out.println("#" + t + " " + min);
		}
		
	}
	
	static void dfs(int idx) {
		
		if(sum >= min) return;
		
		if(idx >= plans.length) {
//			System.out.println("idx: " + idx + ", sum: " + sum);
			min = Math.min(sum, min);
//			System.out.println("=====================");
			return;
		}
		// 하루권
		// 한달권
		// 둘 다 +1 호출
		
//		System.out.println("idx: " + idx + ", sum: " + sum);

		
		
			for(int j = 0; j < 3; j++) {
//				System.out.println(j);
				if(j == 0) {
					sum += plans[idx] * fees[j];
					dfs(idx+1);
					sum -= plans[idx] * fees[j];
				}else if(j == 1) {
					sum += fees[j];
					dfs(idx+1);
					sum -= fees[j];
				}else {
					sum += fees[j];
					dfs(idx+3);
					sum -= fees[j];
				}
				
			}

	}
}
