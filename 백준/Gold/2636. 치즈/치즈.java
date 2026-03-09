import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, M, time, last_cheese;
    static int[][] map;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }


        while (true) {
            int melt_cnt = bfs();
            if (melt_cnt == 0) break;
            else {
                last_cheese = melt_cnt;
            }

            time++;
        }

        System.out.printf("%d\n%d", time, last_cheese);


    }

    static int bfs() {
        int startR = 0;
        int startC = 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[startR][startC] = true;
        q.add(new int[] {startR, startC});

        int melt_cnt = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if (map[nr][nc] == 1){
                        visited[nr][nc] = true;
                        map[nr][nc] = 0;
                        melt_cnt++;
                    } else {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }

        return melt_cnt;
    }
}
