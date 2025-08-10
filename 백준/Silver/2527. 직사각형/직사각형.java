
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// a: 직사각형
		// b: 선분
		// c: 점
		// d: 공통부분 없음
		
		for(int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			// 점으로 만날 때
			if(p1 < x2 || q1 < y2 || q2 < y1 || p2 < x1) {
				System.out.println("d");
			}
			else if((x1 == p2 && y1 == q2) || (x2 == p1 && y1 == q2) || (x2 == p1 && y2 == q1) || (x1 == p2 && y2 == q1)) {
				System.out.println("c");
			}
			// 선으로 만날 때
			else if(x1 == p2 || y1 == q2 || x2 == p1 || y2 == q1) {
				System.out.println("b");
			}
			// 공통부분이 없을 때
			else {
				System.out.println("a");
			}
			
		}

	}

}
