import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();     // 자리 수
		String seatsInput = sc.next();
		
		Stack<Character> seats = new Stack<>();
		// 좌석 사이에는 컵홀더가 있고, 양 끝 좌석에는 컴홀더가 하나 더 있다.
		// 커플석 사이에는 컵홀더가 없다.
		
		int Lcount = 0;
		for(int i = 0; i < N; i++) {
			if(i == 0) seats.push('*');
			
			char seat = seatsInput.charAt(i);
			// 현재 자리가 S면 컵홀더를 추가한다.
			if(seat == 'S') {
				seats.push(seat);
				seats.push('*');
			}
			// 현재 자리가 L이면 이전에 L이 한번 더 나왔었는지 확인하고
			// 1. L이 나오지 않았다면 L만 넣음
			// 2. L이 나왔었다면 L을 넣고 컵홀더도 넣음
			else {
				if(Lcount == 0) {
					seats.push(seat);
					Lcount++;
				}
				else {
					seats.push(seat);
					seats.push('*');
					Lcount--;
				}
			}
			
		}
		
		int ans = 0;
		// 양 끝 좌석에는 컵홀더가 있으므로 반복문이 끝나고 컵홀더를 하나 넣는다.
		for(int i = 0; i < seats.size(); i++) {
			if(seats.get(i) == '*') ans++;
		}
		
		if(ans > N) ans = N;
		System.out.println(ans);
		sc.close();
	}

}
