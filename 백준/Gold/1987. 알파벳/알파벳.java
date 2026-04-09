import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int R, C, answer = 1;
    static char[][] map;
    static boolean[] alphabet;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // set을 들고 다니면서 set에 넣을 수 있으면 가고 못넣으면 빠꾸
        map = new char[R][C];
        alphabet = new boolean[26];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        alphabet[map[0][0] - 'A'] = true;

        dfs (0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int cnt) {


        answer = Math.max(answer, cnt);


        for (int i = 0; i < 4; i++) {
            int nr = r + drc[i][0];
            int nc = c + drc[i][1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;


            int nextChar = map[nr][nc] - 'A';

            if (!alphabet[nextChar]) {
                alphabet[nextChar] = true;
                dfs(nr, nc, cnt+1);
                alphabet[nextChar] = false;
            }

        }

    }

}
