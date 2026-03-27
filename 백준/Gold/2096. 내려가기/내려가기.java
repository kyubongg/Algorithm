import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] boards = new int[T][3];
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				boards[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dpMax = new int[T][3];
		int[][] dpMin = new int[T][3];
		dpMax[0] = boards[0];
		dpMin[0] = boards[0];

		for (int r = 1; r < T; r++) {
			dpMax[r][0] = Math.max(dpMax[r - 1][0], dpMax[r - 1][1]) + boards[r][0];
			dpMax[r][1] = Math.max(dpMax[r - 1][0], Math.max(dpMax[r - 1][1], dpMax[r - 1][2])) + boards[r][1];
			dpMax[r][2] = Math.max(dpMax[r - 1][1], dpMax[r - 1][2]) + boards[r][2];

			dpMin[r][0] = Math.min(dpMin[r-1][0], dpMin[r-1][1]) + boards[r][0];
			dpMin[r][1] = Math.min(dpMin[r - 1][0], Math.min(dpMin[r - 1][1], dpMin[r - 1][2])) + boards[r][1];
			dpMin[r][2] = Math.min(dpMin[r-1][1], dpMin[r-1][2]) + boards[r][2];
			
			
		}

		System.out.println(Math.max(dpMax[T-1][0], Math.max(dpMax[T-1][1], dpMax[T-1][2])) + " " + Math.min(dpMin[T-1][0], Math.min(dpMin[T-1][1], dpMin[T-1][2])));

	}

}
