
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		// 문자열의 길이를 받고
		// 문자열의 약수 중 R <= C 인 R과 C를 찾는다.
		int N = str.length();
		int R = 0;
		int C = 0;
		
		for(int i = 1; i <= Math.sqrt(N); i++) {
			if(N % i == 0) {
				R = i; 
				C = N / i;
			}
		}


		// 문자열 길이 / 열 만큼 늘리면서 sb에 붙인다
		int interval = N / C;
		StringBuilder sb = new StringBuilder();
		
		// 시작 위치
		int i = 0;
		while(sb.length() < N) {
			
			// C만큼 반복
			for(int j = 0; j < C; j++) {
				sb.append(str.charAt(i+interval*j));
			}
			i++;
		}
		
		System.out.println(sb.toString());
		
		
		
		sc.close();
	}

}
