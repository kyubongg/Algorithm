import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int num, weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        // 다익스트라 시간 복잡도 : O(ElogV) => 최대 450만번 정도일듯?
        // 그래프 정보를 담을 동적 배열
        List<Node>[] graphs = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            graphs[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graphs[u].add(new Node(v, w));
        }

        int[] weights = new int[V+1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue();
        weights[K] = 0;
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 현재 노드와 연결된 다른 노드들을 탐색
            for (Node n : graphs[node.num]) {
                // n 노드까지의 기록된 거리보다 node 까지의 거리 + n.weight가 작으면
                if (weights[n.num] > node.weight + n.weight) {
                    weights[n.num] = node.weight + n.weight;
                    pq.add(new Node(n.num, weights[n.num]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (weights[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(weights[i]).append("\n");
            }
        }

        System.out.println(sb.toString());

    }


}
