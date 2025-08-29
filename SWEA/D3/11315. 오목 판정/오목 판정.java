import java.util.Scanner;

public class Solution {

	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			boolean isYes = false;
			label:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 'o') {
						
						
						for(int k = 0; k < 8; k++) {
							int cnt = 1;
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							for(int m = 1; m <= 5; m++) {
								if(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 'o') {
									cnt++;
									nr += dr[k];
									nc += dc[k];
								}
							}
							
							if(cnt >= 5) {
								isYes = true;
								break label;
							}
						}
						
						
					}
				}
			}
			
			if(isYes) System.out.println("#" + t + " YES");
			else System.out.println("#" + t + " NO");
			
		}
		
	}
	


}
