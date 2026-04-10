import java.util.*;
import java.io.*;

public class Main {
    // 데스 나이트가 이동 가능한 6방향 정의
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        // 방문 여부와 거리를 동시에 저장 (-1로 초기화)
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 설정
        queue.add(new int[]{r1, c1});
        dist[r1][c1] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // 목표 지점 도달 시 출력 후 종료
            if (r == r2 && c == c2) {
                System.out.println(dist[r][c]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 체스판 범위 내에 있고 아직 방문하지 않은 경우
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (dist[nr][nc] == -1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        // 도달할 수 없는 경우
        System.out.println("-1");
    }
}