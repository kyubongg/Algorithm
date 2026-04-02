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

        // N : 도시 수, M : 도로 수, K : k번째 짧은 최단 경로
        // 항상 1번 도시부터 출발
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시간복잡도 : O(ElogV) -> 250000

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, dist));
        }
        // 1. 다익스트라를 통해서 최단 경로를 구한다.

        // 2. 각 노드별로 k개의 최단 경로를 구한다.

        // 2.1. 해당 노드의 최대 힙 개수가 K보다 작으면 그냥 넣음
        // 2.2. 해당 노드의 최대 힙 개수가 K보다 크면
        // 2.2.1. 새로운 거리가 최대 힙의 루트보다 작으면 루트를 제거하고 새로운 거리를 넣음

        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer>[] distHeapArr = new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            distHeapArr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }


        pq.add(new Node(1, 0));
        distHeapArr[1].add(0);
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Node next : nodes[curr.num]) {
                int nextDist = next.dist + curr.dist;

                if (distHeapArr[next.num].size() < K) {
                    distHeapArr[next.num].add(nextDist);
                    pq.add(new Node(next.num, nextDist));
                } else {
                    if (distHeapArr[next.num].peek() > nextDist) {
                        distHeapArr[next.num].poll();
                        distHeapArr[next.num].add(nextDist);
                        pq.add(new Node(next.num, nextDist));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distHeapArr[i].size() < K) {
                sb.append(-1).append("\n");
            } else {
                sb.append(distHeapArr[i].peek()).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}
