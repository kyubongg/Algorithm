import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // D개의 도토리를 N개의 상자에 담아 숨기려고 함
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long D = Integer.parseInt(st.nextToken());

        int[][] rules = new int[K][3];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rules[i][0] = Integer.parseInt(st.nextToken());
            rules[i][1] = Integer.parseInt(st.nextToken());
            rules[i][2] = Integer.parseInt(st.nextToken());
        }

        long low = 1;
        long high = N;
        long answer = N;

        while (low <= high) {
            long mid = (low + high) / 2;

            long total = 0;
            for (int i = 0; i < K; i++) {
                int start = rules[i][0];
                int end = rules[i][1];
                int step = rules[i][2];

                if (mid >= start) {
                    int lastBox = Math.min(end, (int) mid);
                    total += (lastBox - start) / step + 1;
                }
            }

            if (total >= D) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        System.out.println(answer);

    }
}
