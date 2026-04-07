import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static List<Integer>[] trees;
    static boolean[] isChecked;
    static int leaf = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // dp 문제임
        // 가치를 높은걸 우선적으로 담고, 가치가 같다면 무게가 작은걸 선택함

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else{
                return a[1] - b[1];
            }
        });
        boolean[] visited = new boolean[100001];

        pq.add(new int[] {S, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;

            if (curr[0] == K) {
                System.out.println(curr[1]);
                break;
            }

            // 앞으로 한칸
            if (curr[0] + 1 <= 100000) pq.add(new int[] {curr[0] + 1, curr[1] + 1});
            // 뒤로 한칸
            if (curr[0] - 1 >= 0) pq.add(new int[] {curr[0] - 1, curr[1] + 1});
            // 두배
            if (curr[0] * 2 <= 100000) pq.add(new int[] {curr[0] * 2, curr[1]});
        }


    }



}
