import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int r, c;
        long weight;

        public Node(int r, int c, long weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.weight - o.weight);
        }
    }

    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // K : 전투선 클래스 개수
            int K = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            // 실제 전투선 배치도
            int[][] map = new int[H][W];
            // 엔터프라이즈호에서 출구까지의 거리도
            long[][] weights = new long[H][W];

            // 각 전투선을 파괴하는데 걸리는 시간 map
            Map<String, Integer> times = new HashMap<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                times.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            int startR = 0, startC = 0;
            for (int r = 0; r < H; r++) {
                String[] input = br.readLine().split("");
                Arrays.fill(weights[r], Long.MAX_VALUE);
                for (int c = 0; c < W; c++) {
                    if (input[c].equals("E")) {
                        map[r][c] = 0;
                        startR = r;
                        startC = c;
                    } else {
                        map[r][c] = times.get(input[c]);
                    }
                }
            }

            // 출발점부터 시작
            PriorityQueue<Node> pq = new PriorityQueue();
            pq.add(new Node(startR, startC, 0));
            weights[startR][startC] = 0;

            long min = Long.MAX_VALUE;
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.weight > weights[node.r][node.c]) continue;

                if (node.r == 0 || node.r == H-1 || node.c == 0 || node.c == W-1) {
                    min = Math.min(min, weights[node.r][node.c]);
                }

                for (int i = 0; i < 4; i++) {
                    int nr = node.r + drc[i][0];
                    int nc = node.c + drc[i][1];

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        // node.weight : 지금까지 온 경로의 시간의 합
                        // map[nr][nc] : 다음 경로로 가는데 걸리는 시간
                        if (weights[nr][nc] > node.weight + map[nr][nc]) {
                            weights[nr][nc] = node.weight + map[nr][nc];
                            pq.add(new Node(nr, nc, weights[nr][nc]));
                        }
                    }
                }
            }

            System.out.println(min);

        }
    }
}
