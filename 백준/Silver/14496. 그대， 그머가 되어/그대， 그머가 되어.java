import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int a, b, N, M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 무방향 그래프
        List<Integer>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes[from].add(to);
            nodes[to].add(from);
        }

        visited = new boolean[N+1];

        int ans = bfs(a, b, nodes);
        System.out.println(ans);
    }

    static int bfs(int start, int end, List<Integer>[] nodes) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == end) {
                return node[1];
            }

            for (int n : nodes[node[0]]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(new int[] {n, node[1] + 1});
                }
            }
        }

        return -1;
    }

}
