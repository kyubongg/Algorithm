import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] edges;
    static int[] visited;
    static boolean hasCycle = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N+2];   // 0: 방문 x, 1: 방문 중 (DFS 하는중), 2: 방문 o
        edges = new ArrayList[N+2];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            int crossNum = Integer.parseInt(br.readLine());
            String line = br.readLine();

            st = new StringTokenizer(line);
            for (int j = 0; j < crossNum; j++) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }

        }

        solve(1);

        System.out.println(hasCycle ? "CYCLE" : "NO CYCLE");

    }

    static void solve(int u) {
        if (hasCycle) return;

        visited[u] = 1;
        for (int v : edges[u]) {
            // N번 노드까지 도착하면 사이클이 없음.
            if (visited[v] == 1) {
                hasCycle = true;
                break;
            } else if(visited[v] == 0) {
                solve(v);
            }

            if (hasCycle) return;
        }

        visited[u] = 2;

    }
}
