import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int c, time;

        public Node(int c, int weight) {
            this.c = c;
            this.time = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.time - o.time);
        }
    }

    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            List<Node>[] computers = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                computers[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                computers[from].add(new Node(to, cost));
            }

            int[] times = new int[n+1];
            Arrays.fill(times, INF);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));
            times[start] = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.time > times[node.c]) continue;

                for (Node next : computers[node.c]) {
                    if (times[next.c] > next.time + times[node.c]) {
                        times[next.c] = next.time + times[node.c];
                        pq.add(new Node(next.c, times[next.c]));
                    }
                }
            }

            int cnt = 0;
            int time = 0;
            for (int i = 1; i <= n; i++) {
                if (times[i] < INF) {
                    cnt++;
                    time = Math.max(time, times[i]);
                }
            }

            sb.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.println(sb.toString());

    }
}
