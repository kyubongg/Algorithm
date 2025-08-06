
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int checkNum = sc.nextInt();
			
			int[] checkPoints = new int[checkNum];
			for(int i = 0; i < checkNum; i++) {
				checkPoints[i] = sc.nextInt();
			}
			
			// 1. 체크포인트 중 한곳을 제외하고 이동해야 하는 거리를 잰다.
			// 2. 최소 거리와 비교하여 더 작은 값을 최소 거리로 만든다.
			
			// 계산에서 제외할 체크포인트 인덱스
			int exclude = 1;
			int min = Integer.MAX_VALUE;
			
			
			while(exclude < checkNum) {
				int sum = 0;
				for(int i = 0; i < checkNum-1; i++) {
					if(i == exclude) continue;
					else if(i+1 == exclude && exclude != checkNum-1) {
						sum += Math.abs(checkPoints[i] - checkPoints[i+2]);
					}
					else {
						sum += Math.abs(checkPoints[i] - checkPoints[i+1]);
						
					}
					
				}
				
				
				
				min = Math.min(sum, min);
				exclude++;
			}
			
			System.out.println(min);
		}
	}
}
