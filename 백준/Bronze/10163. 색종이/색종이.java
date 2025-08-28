import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[1001][1001];
		
		// 너비, 높이 반대로 바꾸기
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			for(int r = startR; r < startR + H; r++) {
				for(int c = startC; c < startC + W; c++) {
					arr[r][c] = t;
				}
			}
		}
		
		int[] papers = new int[101];
		
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				if(arr[i][j] != 0) papers[arr[i][j]]++;
			}
		}
		
		for(int i = 1; i <= tc; i++) {
			System.out.println(papers[i]);
		}
	}

}
