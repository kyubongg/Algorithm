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

        List<Integer>[] exams = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            exams[i] = new ArrayList<>();
        }

        int[] indegrees = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            exams[from].add(to);
            indegrees[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int exam = pq.poll();

            sb.append(exam).append(" ");

            for (int i = 0; i < exams[exam].size(); i++) {
                indegrees[exams[exam].get(i)]--;
                if (indegrees[exams[exam].get(i)] == 0) {
                    pq.add(exams[exam].get(i));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
