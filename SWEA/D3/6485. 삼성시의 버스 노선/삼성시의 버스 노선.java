import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// 버스 정류장 번호: 1~5,000
		// 버스 노선 개수: N
		//	i번째 버스 노선: 번호가 A 이상, B이하인 정류장만 감
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();	// 노선 개수
			
			int[][] busWay = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				busWay[i][0] = sc.nextInt();	// A: 버스 노선 시작 번호
				busWay[i][1] = sc.nextInt();	// B: 버스 노선 마지막 번
			}
			
			int P = sc.nextInt();				// 검색할 버스 정류장 개수
			
			int[] busStops = new int[5001];		// 1 ~ N까지 셀거기 때문에 P+1로 설정
			
			for(int i = 0; i < busWay.length; i++) {
				
				int start = busWay[i][0];
				int end = busWay[i][1];
				
				for(int j = start; j <= end; j++) {
					if(j >= busStops.length) break;
					busStops[j]++;
				}
			}

			int[] stops = new int[P];
			for(int i = 0; i < P; i++) {
				stops[i] = sc.nextInt();
			}
			
			
			System.out.print("#" + t + " ");
			int ans = 0;
			for(int i = 0; i < stops.length; i++) {
				ans = busStops[stops[i]];
				System.out.print(ans + " ");
			}
			
			System.out.println();
		}
		
	}

}
