import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt(); // N : 학생 수
		int K = scanner.nextInt(); // K : 한 방에 들어갈 수 있는 최대 학생 수
		int maxGrade = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		
		// 수학여행 참여 인원의 학년과 성별을 키로 만들어 HashMap에 저장
		for(int i = 0; i < N; i++) {
			int S = scanner.nextInt(); // S : 성별
			int Y = scanner.nextInt(); // Y : 학년
			// 몇학년까지 왔는지 체크
			maxGrade = Math.max(maxGrade, Y);
			String key = S + "-" + Y;
			
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		// 반복문을 통해 각 학년의 성별에 따른 인원수를 체크
		// 인원수 / K를 통해 방의 개수를 증가
		int rooms = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j <= maxGrade; j++) {
				String key = i + "-" + j;
				
				int count = map.getOrDefault(key, 0);
				rooms += (count + K - 1) / K;
			}
		}

		System.out.println(rooms);

	}
}