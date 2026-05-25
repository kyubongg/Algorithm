import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][N+1];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // T초 반복
        for (int t = 0; t < T; t++) {
            
            for (int r = 0; r < 3; r++) {
                for (int c = N; c > 0 ; c--) {
                    arr[r][c] = arr[r][c-1];
                }
            }

            for (int r = 1; r < 3; r++) {
                arr[r][0] = arr[r-1][N];
            }

            arr[0][0] = arr[2][N];
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(arr[r][c] + " ");
            }

            System.out.println();
        }

    }
}