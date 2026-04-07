import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, answer;
    static int[][] drc = {{0, 1}, {1, 0}, {1, 1}};
    static int[][] house;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[N][N];
        house = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                house[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTrack(0, 1, 0);

        // 백트래킹 해야함
        // 매 횟수마다 3방향으로 갈라짐
        // 가로 : 파이프 헤드 부분 col + 1이 0이어야함
        // 세로 : 파이프 헤드 부분 row + 1이 0이어야함
        // 대각선 : 파이프 헤드부분 (col + 1, row + 1), col + 1, row + 1 부분이 0이어야함

        System.out.println(answer);
    }

    static void backTrack (int r, int c, int prev) {

        if (r == N-1 && c == N-1) {
            answer++;
            return;
        }

        // 회전은 45도만 가능 즉 가로 -> 세로 이건 안됨
        // 0 : 가로
        // 1 : 세로
        // 2 : 대각선

        if (prev == 0 || prev == 2) {
            if (c + 1 < N && house[r][c+1] == 0) {
                backTrack(r, c+1, 0);     // 가로 이동
            }
        }

        if (prev == 1 || prev == 2) {
            if (r + 1 < N && house[r+1][c] == 0) {
                backTrack(r + 1, c, 1);
            }
        }

        if (r + 1 < N && c + 1 < N) {
            if (house[r + 1][c] == 0 && house[r + 1][c + 1] == 0 && house[r][c + 1] == 0) {
                backTrack(r + 1, c + 1, 2);
            }
        }

    }


}
