import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 스위치켜고끄기
		// 1 : 스위치가 켜져있음
		// 0 : 스위치가 꺼져있음
		// 남학생(1) : 자기가 받은 수의 배수의 스위치를 토글함
		// 여학생(2) :
		
		// 
		
		Scanner sc = new Scanner(System.in);
		
		int Len = sc.nextInt();       // 스위치 개수
		int[] switchs = new int[Len]; // 스위치 배열
		for(int i = 0; i < Len; i++) {
			switchs[i] = sc.nextInt();
		}
		
		int studentLen = sc.nextInt(); // 학생 수
		
		// 학생 수만큼 반복
		for(int i = 0; i < studentLen; i++) {
			int gender = sc.nextInt();
			// 배열은 0부터 시작하기 때문에 -1을 해준다.
			int sw = sc.nextInt() - 1;
			
			if(gender == 1) {
				// sw에 -1을 했기 때문에 j는 sw+1씩 늘어나야함
				// ex) sw == 3 => 3, 6, 9, 12, ...처럼 3씩 늘어나야하지만
				//	   sw에 1을 더하지 않으면 3, 5, 7, 9, ... 처럼 2씩 늘어남
				for(int j = sw; j < switchs.length; j += sw+1) {
					if(switchs[j] == 1) switchs[j] = 0;
					else switchs[j] = 1;
				}
			}
			else {
				// 입력받은 숫자의 좌우칸이 같은지 확인
				// 입력받은 숫자의 좌우칸이 스위치 배열 내부일때만 실행
				int left = sw-1;
				int right = sw+1;
				// 입력받은 인덱스를 토글
				if(switchs[sw] == 1) switchs[sw] = 0;
				else switchs[sw] = 1;
				
				// left와 right가 배열 크기 내에 있고 switchs[left] == switchs[right] 일때만 토글
				while(left >= 0 && right < switchs.length && switchs[left] == switchs[right]) {
					if(switchs[left] == 1) switchs[left] = 0;
					else switchs[left] = 1;
					
					if(switchs[right] == 1) switchs[right] = 0;
					else switchs[right] = 1;
					
					// 좌우 한칸씩 늘리기
					left--;
					right++;
				}
				
				
			}
		}
		
		for(int i = 0; i < switchs.length; i++) {
			System.out.print(switchs[i] + " ");
			if((i+1)%20 == 0) System.out.println();
		}
	}
	
	

}
