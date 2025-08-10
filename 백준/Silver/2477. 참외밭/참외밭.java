import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 가로 세로 중 가장 긴 변들의 위치를 찾는다.
		// 2. 1번 변들과 붙어 있는 변들을 제외하고 남은 변들의 위치를 찾는다.
		// 3. (1번 변을 곱한 값 - 2번 변을 곱한 값) * K를 출력한다.
		
		// 1m^2에서 자라는 참외의 개수
		int K = sc.nextInt();
	
		int rowMax = 0;
		int colMax = 0;
		int rowMaxIdx = 0;
		int colMaxIdx = 0;
		
		int[] lens = new int[6];
		

		
		// 동쪽: 1, 서쪽: 2, 남쪽: 3, 북쪽: 4
		for(int i = 0; i < 6; i++) {
			int dir = sc.nextInt();		// 변의 방향
			int len = sc.nextInt();		// 변의 길이
			lens[i] = len;
			// 가장 긴 가로길이, 인덱스 찾기
			if(dir == 1 || dir == 2) {
				if(len > rowMax) {
					rowMax = len;
					rowMaxIdx = i;
				}
			}
			// 가장 긴 세로길이, 인덱스 찾기
			else {
				if(len > colMax) {
					colMax = len;
					colMaxIdx = i;
				}
			}
		}
	
		List<Integer> list = new ArrayList<>();
		// 왼쪽 +1 -> %6
		// 오른쪽 + 6 - 1 % 6
		for(int i = 0; i < 6; i++) {
			// 가장 큰 변의 길이는 넘어감
			if(i == rowMaxIdx || i == colMaxIdx) continue;
			// 가장 큰 변의 길이 주변 값들도 넘어감
			if(i == (rowMaxIdx+1)%6 || i == (rowMaxIdx+6-1)%6 || i == (colMaxIdx+1)%6 || i == (colMaxIdx+6-1)%6) continue;
			
			list.add(lens[i]);
		}
		
		int max = rowMax * colMax;
		int min = list.get(0) * list.get(1);
		
		System.out.println((max - min) * K);
		
	}

}
