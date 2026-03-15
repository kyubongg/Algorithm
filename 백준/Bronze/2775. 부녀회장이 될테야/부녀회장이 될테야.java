import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static int[] spaces;
	static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] apart = new int[15][15];
		
		for (int i = 1; i <= 14; i++) {
			apart[0][i] = i;
		}
		
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				int sum = 0;
				for(int k = 1; k <= j; k++) {
					sum += apart[i-1][k];
				}
				apart[i][j] = sum;
			}
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			
			System.out.println(apart[k][n]);
		}
		
 	}

	
	
	
	
	
}
