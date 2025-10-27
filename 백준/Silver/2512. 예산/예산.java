import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 지방 개수
		int[] costs = new int[N];	 
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			costs[i] = num;
			sum += num;
		}
		
		int M = sc.nextInt();
		
		Arrays.sort(costs);
		if(sum <= M) {
			System.out.println(costs[costs.length-1]);
		}else {
			// 520 / 4 = 130
			int upperLimit = costs[costs.length-1];
			int lowerLimit = M / N;
			
			int max = 0;
			
			
			for(int limit = upperLimit; limit >= lowerLimit; limit--) {
				int cost = 0;
				boolean isOver = false;
				
				for(int j = 0; j < costs.length; j++) {
					
					if(limit >= costs[j]) {
						cost += costs[j];
					}else {
						cost += limit;
					}
					
					if(cost > M) {
						isOver = true;
						break;
					}
				}
				
				
				if(!isOver)	{
					max = Math.max(max, limit);
				}
			}
			
			System.out.println(max);
		}
		
		sc.close();
	}
}
