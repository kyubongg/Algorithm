import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 늘어나는 개수
		// 1번 반복 -> 6개
		// 2번 반복 -> 12개
		// 3번 반복 -> 18개
		// ....
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = 1;
		int plus = 6;
		int num = 1;
		
		if(N == 1) System.out.println(ans);
		else {
			while(num + plus < N) {
				num = num + plus;
				plus += 6;
				ans++;
			}
			System.out.println(ans+1);
		}
	}

}
