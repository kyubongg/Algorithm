import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// N명의 사람이 게임 같이함
		// 한 사람이 공을 M번 받으면 끝남
		
		// 게임 진행 방식
		// 1. 공을 M번보다 작게 받은 사람
		// 1.1 현재 공을 받은 횟수가 홀수 => 현재 위치에서 시계 방향으로 L번째 있는 사람
		// 1.2 현재 공을 받은 횟수가 짝수 => 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람
		// 2. 시작은 1번 자리에 앉은 사람이 던짐(여기서는 0번으로 시작)
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();   // 사람 수
		int M = sc.nextInt();   // 게임이 끝나는 기준
		int L = sc.nextInt();   // 공을 던질 칸 수
		
		// 게임 참가자 배열
		int[] members = new int[N];
		int current = 0;
		int total = 0;
		
		// 1번은 시작하자마자 받기때문에 1로 설정
		members[current] = 1;
		// 0 ~ 4
		// 홀수					짝수
		// 0 -> 2				0 -> 3
		// 1 -> 3				4 -> 2
		// 2 -> 4				3 -> 1
		// 3 -> 0				2 -> 0
		// 4 -> 1				1 -> 4
		// (현재위치 + L) % (N)	(현재위치 + N - L) % (N)
		while(members[current] < M) {
			// 현재 current의 사람이 공을 받은 횟수가 홀수라면
			// 홀수 공식에 맞는 인덱스의 값 증가
			if(members[current] % 2 != 0) {
				current = (current + L) % N;
				members[current]++;
			}
			// 현재 current의 사람이 공을 받은 횟수가 짝수라면
			// 짝수 공식에 맞는 인덱스의 값 증가
			else {
				current = (current + N - L) % N;
				members[current]++;
			}
			
			total++;
		}
		
		System.out.println(total);
	}

}
