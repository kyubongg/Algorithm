import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 참가자 수
		int par1 = sc.nextInt();	// 김지민 번호
		int par2 = sc.nextInt();	// 임한수 번호
		
		// par1은 항상 par2보다 작다
		// 토너먼트가 한판 끝나면 노드 수가 1/2배가 된다
		int count = 0;
		
		// 홀수 번호 사람은 토너먼트 한번 진행 후 숫자가 +1 / 2가 된다
		// 짝수 번호 사람은 토너먼트 한번 진행 후 숫자가 /2 가 된다.
		while(true) {
			if(par1 % 2 != 0) {
				par1 = (par1 + 1) / 2;
			}else {
				par1 = par1/2;
			}
			
			if(par2 % 2 != 0) {
				par2 = (par2 + 1) / 2;
			}else {
				par2 = par2 / 2;
			}
			
			count++;
			
			if(par1 == par2) {
				break;
			}

		}
		
		System.out.println(count);
	}

}
