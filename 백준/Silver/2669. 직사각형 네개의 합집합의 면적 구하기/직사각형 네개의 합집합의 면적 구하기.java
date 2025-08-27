import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int[][] points = new int[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				points[i][j] = sc.nextInt();
			}
		}
		
		// x,y 최대값 찾기
		int maxX = 0;
		int maxY = 0;
		for(int i = 0; i < 4; i++) {
			maxX = Math.max(maxX, points[i][2]);
			maxY = Math.max(maxY, points[i][3]);
		}

		int[][] arr = new int[maxY+1][maxX+1];
		
		for(int i = 0; i < 4; i++) {
			int leftX = points[i][0];
			int leftY = points[i][1];
			int rightX = points[i][2];
			int rightY = points[i][3];
			
			for(int c = leftX; c < rightX; c++) {
				for(int r = leftY; r < rightY; r++) {
					arr[r][c]++;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= maxY; i++) {
			for(int j = 0; j <= maxX; j++) {
				if(arr[i][j] > 0) ans++; 
			}
		}
		System.out.println(ans);
	}

}
