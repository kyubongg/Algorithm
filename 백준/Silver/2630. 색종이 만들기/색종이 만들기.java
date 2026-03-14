import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, white = 0, blue = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    // k : 한 변의 길이
    static void partition(int r, int c, int size) {
        if (isUniform(r, c, size)) {
            if (map[r][c] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;

        partition(r, c, newSize);
        partition(r + newSize, c, newSize);
        partition(r, c + newSize, newSize);
        partition(r + newSize, c + newSize, newSize);
    }

    static boolean isUniform(int startR, int startC, int size) {
        int color = map[startR][startC];

        for (int r = startR; r < startR + size; r++) {
            for (int c = startC; c < startC + size; c++) {
                if (color != map[r][c]) return false;
            }
        }

        return true;
    }
}
