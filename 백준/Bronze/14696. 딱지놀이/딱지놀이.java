import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 딱지놀이의 라운드 수
		int num = 0;
		
		for(int t = 1; t <= N; t++) {
			int aNum = sc.nextInt();
			int[] aCards = new int[5];
			
			for(int i = 0; i < aNum; i++) {
				num = sc.nextInt();
				aCards[num]++;
			}
			
			int bNum = sc.nextInt();
			int[] bCards = new int[5];
			
			for(int i = 0; i < bNum; i++) {
				num = sc.nextInt();
				bCards[num]++;
			}
			
			// 뒤에서부터 개수를 비교
			// 개수가 적은 사람이 진다.
			String winner = "";
			for(int i = 4; i >= 1; i--) {
				if(aCards[i] > bCards[i]) {
					winner += "A";
					break;
				}
				else if(aCards[i] < bCards[i]) {
					winner += "B";
					break;
				}
			}
			
			if(winner.equals("")) winner += "D";
			
			System.out.println(winner);
		}
		
		
	}

}
