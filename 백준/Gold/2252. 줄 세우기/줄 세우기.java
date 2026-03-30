import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // O(E+V)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 진입 차수 배열
        int[] indegrees = new int[N+1];
        List<Integer>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // A에서 B로 가는 간선이고
            nodes[A].add(B);
            // B의 차수를 하나 늘린다.
            indegrees[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }


        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();

            result.add(node);

            for (int i = 0; i < nodes[node].size(); i++) {
                indegrees[nodes[node].get(i)]--;
                if (indegrees[nodes[node].get(i)] == 0) {
                    queue.offer(nodes[node].get(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }


}
