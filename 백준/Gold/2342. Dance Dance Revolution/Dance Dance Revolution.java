
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1. 두 발을 동시에 움직이지 못함
         * 2. 두 발이 같은 지점에 있을 수 없음
         * 3. 발을 움직이는 위치에 따라 드는 힘이 다름
         *
         *  3.1. 중앙 -> 다른 곳 : 2
         *  3.2. 한 방향 -> 인접한 다른 방향 : 3
         *  3.3. 반대편 : 4
         *
         * 입출력 제한사항
         * - 입력: 0은 수열의 마지막을 의미함. 입력되는 수열의 길이 : 최대 100,00개
         * - 출력: 모든 지시사항 만족하는 최소의 힘
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> seq = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 0) {
                System.out.println(solve(seq));
                return;
            }
            seq.add(x);
        }

    }

    static int solve(List<Integer> seq) {
        int[][] dp = new int[5][5];
        int[][] ndp = new int[5][5];

        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;
        for (int x : seq) {
            for (int i = 0; i < 5; i++) {
                Arrays.fill(ndp[i], INF);
            }

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    int cur = dp[l][r];
                    if (cur == INF) continue;

                    if (x != r) {
                        ndp[x][r] = Math.min(ndp[x][r], cur + getCost(l, x));
                    }

                    if (x != l) {
                        ndp[l][x] = Math.min(ndp[l][x], cur + getCost(r, x));
                    }
                }
            }

            int[][] tmp = dp;
            dp = ndp;
            ndp = tmp;
        }

        int ans = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                ans = Math.min(ans, dp[l][r]);
            }
        }
        return ans;
    }

    static int getCost(int from, int to) {

        if (from == to) return 1;
        if (from == 0) return 2;
        int diff = Math.abs(from - to);
        if (diff == 2) return 4;
        return 3;

    }
}
