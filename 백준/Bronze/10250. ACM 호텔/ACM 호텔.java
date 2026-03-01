import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
            int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수 (실제 계산엔 안 쓰임)
            int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님

            int floor, room;

            if (N % H == 0) {
                // N이 H의 배수인 경우 (꼭대기 층)
                floor = H;
                room = N / H;
            } else {
                floor = N % H;
                room = (N / H) + 1;
            }

            // 호수는 무조건 2자리로 출력해야 함 (예: 1호 -> 01)
            sb.append(floor).append(String.format("%02d", room)).append("\n");
        }
        System.out.print(sb);
    }
}