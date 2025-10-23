import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] nums;
	static char[] operators = {'+', '-', '*', '%'};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		
		N = sc.nextInt();
		
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int[] operator = new int[4];
		for(int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		
		dfs(1, nums[0], operator);
		
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	
	static void dfs(int select, int result, int[] operator) {
		// 연산자 배치가 끝나면, 최대/최소값과 비교
		if(select == N) {
			
			min = Math.min(min, result);
			max = Math.max(max, result);
			
			
			return;
		}
		
		
		for(int i = 0; i < operator.length; i++) {
			if(operator[i] == 0) continue;
			
			
			for(int j = operator[i]; j > 0; j--) {
				
				// operators: 0 : '+', 1 : '-', 2 : '*', 3 : '%'
				if(i == 0) {
					operator[i]--;
					dfs(select + 1, result + nums[select], operator);
					operator[i]++;
				}else if(i == 1) {
					operator[i]--;
					dfs(select + 1, result - nums[select], operator);
					operator[i]++;
				}else if(i == 2) {
					operator[i]--;
					dfs(select + 1, result * nums[select], operator);
					operator[i]++;
				}else {
					operator[i]--;
					dfs(select + 1, result / nums[select], operator);
					operator[i]++;
				}
			}
			
		}
		
		
	}
	
}
