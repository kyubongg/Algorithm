import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int num, dist;

        public Node(int c, int weight) {
            this.num = c;
            this.dist = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }

        @Override
        public String toString() {
            return "[num: " + num + ", dist: " + dist + "]";
        }
    }

    static int INF = 100_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= test_case; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            List<Node>[] nodes = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                int weight = time * 2;
                if ((from == G && to == H) || (from == H && to == G)) {
                    weight -= 1;
                }

                nodes[from].add(new Node(to, weight));
                nodes[to].add(new Node(from, weight));
            }

            int[] candidates = new int[T];
            for (int i = 0; i < T; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }

            // 목적지
            // - 듀오가 지나간 간선(S-H)이 포함된 경로 중 최단 경로를 계산
            // - 목적지 후보 중 거리가 가장 짧은 곳이 목적지들이 됨.
            // - 여러 목적지의 최단 거리를 오름차순으로 출력

            // E : 2 ~ 2000, V : 1 ~ 50000, T : 1 ~ 100
            // 다익스트라 : O(ElgoV) -> 50000 * 11 -> 550000 * 100 -> 55000000
            // 1. 최단 경로를 구함
            //  1.1. 최단 경로를 구할 때 부모 노드를 저장함
            // 2. 도착 후보지들의 최단 경로에 S-H가 있는지 확인
            //  2.1. 있으면 정답 리스트에 넣고 break
            //  2.2. 없으면 패스

            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] parent = new int[N+1];
            int[] dist = new int[N+1];
            Arrays.fill(dist, INF);

            // 1번
            pq.add(new Node(S, 0));
            dist[S] = 0;
            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                if (curr.dist > dist[curr.num]) continue;

                for (Node next : nodes[curr.num]) {
                    if (dist[next.num] > next.dist + dist[curr.num]) {
                        dist[next.num] = next.dist + dist[curr.num];
                        pq.add(new Node(next.num, dist[next.num]));
                    }
                }
            }

            PriorityQueue<Integer> answer = new PriorityQueue<>();
            for (int i = 0; i < T; i++) {
                int candidate = candidates[i];

                if (dist[candidate] % 2 != 0) {
                    answer.add(candidate);
                }
            }

            while (!answer.isEmpty()) {
                sb.append(answer.poll()).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
