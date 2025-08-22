import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 1: 가속
		// 2: 감속
		// 0: 속도 유지
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();		// 입력이 주어지는 개수
			
			
			
			int speed = 0;
			int ans = 0;
			for(int i = 0; i < N; i++) {
				int v = sc.nextInt();		// 속도 관련 입력
				int value = 0;
				
				if(v != 0) {
					value = sc.nextInt();	// 속도 조정값
				}
				
				if(v == 1) {
					speed += value;
				}else if(v == 2) {
					speed -= value;
				}
				
				if(speed < 0) speed = 0;
				ans += speed;
				
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
