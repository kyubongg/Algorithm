import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // i번째 친구가 들고 있는 트랙의 길이는 i이다.
        // a 와 b를 잇는 방법은 da + db이다

        // 모든 방이 연결되게 하는 도로 길이의 최솟값


        // 우선 순위 큐를 쓰면 되지 않을까
        // 1 3 5 7 -> 1,3 연결 1,5 연결 1,7 연결
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int min = pq.poll();
        long ans = 0;
        while(!pq.isEmpty()) {
            int next = pq.poll();
            ans += min+next;
        }

        System.out.println(ans);
    }

}
