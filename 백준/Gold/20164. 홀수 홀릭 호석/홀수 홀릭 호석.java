import java.util.Scanner;

public class Main {
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		// 숫자 N
		// 1. 홀수의 개수를 적음
		// 2. 수가 한자리이면 종료
		// 3. 수가 두자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각
		// 4. 수가 세자리 이상이면 임의의 위치에서 3개의 수로 분할 -> 3개를 더한 값을 새로운 수로 생각
		
		// 숫자의 길이 : 1~9
		// 숫자의 길이가 1일 때 -> 종료
		
		String N = sc.next();
		int cnt = 0;
		// 자르기 전 홀수 개수 세기
		
		
		getValue(N, 0);
		
		System.out.println(MIN + " " + MAX);
	}
	
	static void getValue(String N, int total) {
		
		int curr = 0;
		for(int i = 0; i < N.length(); i++) {
			if(N.charAt(i) % 2 != 0) curr++;
		}
		
		int newTotal = total + curr;
		
		if(N.length() == 1) {
			MIN = Math.min(newTotal, MIN);
			MAX = Math.max(newTotal, MAX);
			return;
		}
		
		if(N.length() == 2) {
			String newN = Integer.toString((N.charAt(0) - '0') + (N.charAt(1) - '0'));
			
			getValue(newN, newTotal);
		}
		
		if(N.length() >= 3){
			// N == 5
			// i: 1 ~ 3
			// j: 2 ~ 4
			for(int i = 1; i < N.length() - 1; i++) {
				for(int j = i+1; j < N.length(); j++) {
					int first = Integer.parseInt(N.substring(0, i));
					int second = Integer.parseInt(N.substring(i, j));
					int third = Integer.parseInt(N.substring(j));
					
//					System.out.println(first + " " + second + " " + third);
//					System.out.println(i + " " + j);
					String newS = Integer.toString(first + second + third);
					
					getValue(newS, newTotal);
				}
			}
		}
	}
	
}
