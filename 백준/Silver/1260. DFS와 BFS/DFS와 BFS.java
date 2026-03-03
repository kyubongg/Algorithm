import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static List<Integer>[] nodes;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes[i]);
        }

        // dfs
        sb = new StringBuilder();
        dfs(V);
        sb.append("\n");

        // bfs
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb.toString());
    }

    static void dfs(int start){
        if (visited[start]) return;

        visited[start] = true;
        sb.append(start).append(" ");
        for (int n : nodes[start]) {
            dfs(n);
        }
    }

    static void bfs(int start){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int i : nodes[u]){
                if (visited[i]) continue;

                visited[i] = true;
                q.add(i);
                sb.append(i).append(" ");
            }
        }
    }
}
