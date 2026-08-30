import java.io.*;
import java.util.*;

public class Main {

    static int MAX = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 주
        int S = Integer.parseInt(st.nextToken());    // 1주 보관에 필요한 비용

        int[] cArr = new int[N+1];
        int[] yArr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            cArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N+1];
        int day = 1;
        for (int i = 1; i <= N; i++) {

            if (cArr[day] + (i-day) * S <= cArr[i]) {
                dp[i] = (cArr[day] + (i-day) * S) * yArr[i] + dp[i-1];

            } else {
                day = i;
                dp[i] = cArr[day] * yArr[i] + dp[i-1];
            }


        }

        System.out.println(dp[N]);
    }

}
