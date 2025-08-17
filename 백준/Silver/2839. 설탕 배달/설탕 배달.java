import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 설탕 봉지: 3킬로, 5킬로
		// 최대한 적은 봉지를 들고 감
		int N = sc.nextInt();
		int sum = 0;
		
		// 5로 시작 -> 3으로 시작
	
		while(true) {
			if(N % 5 == 0) {
				sum += N / 5;
				break;
			}
			
			N -= 3;
			sum++;
			
			if(N < 0) {
				sum = -1;
				break;
			}
		}

		
		System.out.println(sum);
		
		sc.close();
	}

}
