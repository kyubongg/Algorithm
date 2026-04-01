import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int c, cost;

        public Node(int c, int weight) {
            this.c = c;
            this.cost = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.cost - o.cost);
        }
    }

    static int start, end;
    static int[] costs;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최소비용과 경로를 출력
        // 시작점 - 도착점의 경로는 무조건 존재한다

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] cities = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            cities[from].add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 어떤 경로(도시 순서)로 가는지를 확인해야하기 때문에
        // 다익스트라 + 백트래킹 방식으로 풀어야한다.

        // 출발지에서 해당 목적지까지 가는 최소 비용을 담을 배열
        costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        getMinCosts(cities, start, end);

        // 최소 비용으로 목적지에 도착했을 때의 경로
        Stack<Integer> minCostTracks = getMinTracks(end);

        System.out.println(costs[end]);
        System.out.println(minCostTracks.size());

        while (!minCostTracks.isEmpty()) {
            System.out.print(minCostTracks.pop() + " ");
        }


    }

    // tracks : 목적지에 도착했을 때의 경로
    static void getMinCosts(List<Node>[] cities, int start, int end) {

        parent = new int[cities.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost > costs[node.c]) continue;

            for (Node n : cities[node.c]) {
                if (costs[n.c] > n.cost + costs[node.c]) {
                    costs[n.c] = n.cost + costs[node.c];
                    parent[n.c] = node.c;
                    pq.add(new Node(n.c, costs[n.c]));
                }
            }
        }
    }

    static Stack<Integer> getMinTracks(int end) {

        Stack<Integer> stack = new Stack<>();
        int curr = end;

        while(curr != 0) {
            stack.push(curr);
            curr = parent[curr];
        }

        return stack;
    }
}
