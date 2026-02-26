import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static boolean[][] map;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : map의 크기
        // M : 포자의 개수
        // K : 포자를 심으면 자라나는 칸의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 버섯이 자랄 수 있는 칸 : 0
        // 버섯이 자랄 수 없는 칸 : 1

        map = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("0")) {
                    map[i][j] = true;
                }
            }
        }

        boolean isUsed = false; // 버섯 포자 사용여부
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j]) {
                    int areaSize = getAreaSize(i, j);

                    if (areaSize % K != 0) {
                        M -= areaSize / K + 1;
                    } else {
                        M -= areaSize / K;
                    }

                    isUsed = true;
                }
            }

            if (M < 0) break;
        }

        if (!isUsed || M < 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M);
        }

 
    }

    static int getAreaSize(int r, int c) {


        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {r, c});
        visited[r][c] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc]) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    area++;
                }
            }
        }

        return area;
    }
}
