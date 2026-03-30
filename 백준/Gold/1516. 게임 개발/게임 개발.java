import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        // 전체 정답 배열
        int[] totalTimes = new int[N+1];
        // 각 건물을 짓는데 걸리는 시간 배열
        int[] times = new int[N+1];
        // 각 건물의 선후관계 그래프 리스트 배열
        List<Integer>[] structures = new ArrayList[N+1];
        // 각 건물의 입력 차수를 세는 배열
        int[] indegrees = new int[N+1];

        for (int i = 1; i <= N; i++) {
            structures[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // 건물 짓는데 걸리는 시간
            int time = Integer.parseInt(st.nextToken());

            times[i] = time;
            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) break;

                structures[input].add(i);
                indegrees[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                totalTimes[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int structureIdx = queue.poll();

            for (int i = 0; i < structures[structureIdx].size(); i++) {
                int next = structures[structureIdx].get(i);
                indegrees[next]--;
                totalTimes[next] = Math.max(totalTimes[structureIdx] + times[next], totalTimes[next]);
                if (indegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(totalTimes[i]);
        }
    }


}
