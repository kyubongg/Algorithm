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

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물건의 무게와 가치를 저장할 2차원 배열
        int[][] objects = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            objects[i][0] = Integer.parseInt(st.nextToken());
            objects[i][1] = Integer.parseInt(st.nextToken());
        }

        // 현재 베낭의 무게에 최대로 담을 수 있는 가치를 저장함
        // row : 물건의 번호, col : 배낭 한도
        // 가방에 물건을 넣을 수 없으면 이전 값 들고옴
        // 가방에 물건을 넣을 수 있으면 현재 가치 + 남은 무게 만큼의 최적값 vs 안넣었을때
        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            int W = objects[i][0];
            int V = objects[i][1];

            for (int j = 1; j <= K; j++) {
                if (j < W) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
                }
            }
        }

        System.out.println(dp[N][K]);

    }



}
