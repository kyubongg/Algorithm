import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] lineups = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            lineups[i] = new ArrayList<>();
        }

        int[] indegrees = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            int[] singers = new int[K];
            for (int j = 0; j < K; j++) {
                singers[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < K-1; j++) {
                int from = singers[j];
                int to = singers[j+1];

                lineups[from].add(to);
                indegrees[to]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();

            sb.append(node).append("\n");
            count++;

            for (int i = 0; i < lineups[node].size(); i++) {
                int next = lineups[node].get(i);
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count == N) System.out.println(sb.toString());
        else System.out.println(0);

    }
}
