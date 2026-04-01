import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int num, time;

        public Node(int c, int weight) {
            this.num = c;
            this.time = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)(this.time - o.time);
        }

        @Override
        public String toString() {
            return "[num: " + num + ", time: " + time + "]";
        }
    }

    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 : 500개, 간선 : 10000개
        // 시간 복잡도 : O(ElogV) -> 10000 * 9 -> 90000번
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            // 다익스트라용 그래프 동적 배열
            List<Node>[] roots = new ArrayList[N];
            // 역추적용 그래프 동적 배열
            List<Node>[] backTrack = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                roots[i] = new ArrayList<>();
                backTrack[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                roots[U].add(new Node(V, P));
                backTrack[V].add(new Node(U, P));
            }
            
            // 최단경로가 아닌 두번째로 짧은 시간에 도달할 수 있는 시간을 출력해야함
            // 거의 최단 경로가 없을 수도 있음

            // 일단 최단경로를 구하긴 해야함
            // 다익스트라로 최단경로를 구할 때 쓰는 조건문을 쓰면 저장이 안될 수 있음

            // 내가 생각한 방법
            // 1. 다익스트라를 통해서 목적지까지의 최단 경로를 구함
            // 2. dfs로 출발지 - 도착지 경로의 거리를 모두 구함
            //  2.1. 거의 최단 경로보다 커지는 값은 경로 탐색을 중단함

            // 다시 생각한 방법
            // 1. 다익스트라를 한번 돌림
            // 2. 최단 경로의 간선을 다 지움
            // 3. 다익스트라를 한번 더 돌려서 거의 최단 경로를 찾음

            int[] times = new int[N];
            Arrays.fill(times, INF);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(S, 0));
            times[S] = 0;

            // 1. 최단경로 구하기
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.time > times[node.num]) continue;

                for (Node next : roots[node.num]) {
                    if (times[next.num] > next.time + times[node.num]) {
                        times[next.num] = next.time + times[node.num];
                        pq.add(new Node(next.num, times[next.num]));
                    }
                }
            }

            // 2. 최단 경로 간선 없애기
            int minRootTime = times[D];

            // 역추적
            Queue<Integer> backTrackQueue = new ArrayDeque<>();
            backTrackQueue.add(D);

            boolean[] visited = new boolean[N];
            while (!backTrackQueue.isEmpty()) {
                int curr = backTrackQueue.poll();

                if (curr == S) continue;

                for (Node prev : backTrack[curr]) {
                    if (times[curr] == times[prev.num] + prev.time) {

                        for (int i = 0; i < roots[prev.num].size(); i++) {
                            if (roots[prev.num].get(i).num == curr) {
                                roots[prev.num].remove(i);
                                break;
                            }
                        }

                        if (!visited[prev.num]) {
                            visited[prev.num] = true;
                            backTrackQueue.add(prev.num);
                        }

                    }
                }
            }

            int[] almostTimes = new int[N];
            Arrays.fill(almostTimes, INF);

            pq.add(new Node(S, 0));
            almostTimes[S] = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.time > almostTimes[node.num]) continue;

                for (Node next : roots[node.num]) {
                    if (almostTimes[next.num] > next.time + almostTimes[node.num]) {
                        almostTimes[next.num] = next.time + almostTimes[node.num];
                        pq.add(new Node(next.num, almostTimes[next.num]));
                    }
                }
            }

            if (almostTimes[D] == INF) {
                sb.append(-1).append("\n");
            } else {
                sb.append(almostTimes[D]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
