import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 국가 예산 총액 배정
        // 정해진 총액 이하에서 가능한 한 최대의 총 예산을 각 지방에 분배하는 문제
        // 규칙 1) 모든 요청이 배정될 수 있는 경우에는 요청한 금액 그대로를 배정
        // 규칙 2) 모든 요청이 배정될 수 없는 경우 -> 특정한 정수 상한액을 계산 -> 그 이상인 예산 요청에는 모두 상한액을 배정 AND 상한액 이하는 요청한 금액을 그대로 배정

        // 지방의 수(N): 3 ~ 10,000, 각 지방의 요청예산: 최대 100,000, 총 예산(M): 최대 10억개
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minBudget = 0;
        int maxBudget = Integer.MIN_VALUE;
        int[] cities = new int[N];

        for (int i = 0; i < N; i++) {
            int city = Integer.parseInt(st.nextToken());

            maxBudget = Math.max(maxBudget, city);
            cities[i] = city;
        }


        int M = Integer.parseInt(br.readLine());


        /**
         * 계획 1
         * - 이분탐색으로 중앙값을 계산 -> 중앙값을 예산 상한선으로 설정
         * - 예산 상한선을 반영해서 각 지방에 분배될 총 예산을 계산
         * - 총 예산이 M보다 크면 중앙값을 더 작게 계산 (maxBudget = half-1)
         * - 총 예산이 M보다 작거나 같으면 중앙값을 더 크게 계산 (maxBudget = half+1)
         */

        Arrays.sort(cities);

        int ans = 0;
        while (minBudget <= maxBudget) {
            int half = (minBudget + maxBudget) / 2;
            int totalBudget = 0;

            // 중앙값보다 작거나 같으면 신청 예산, 중앙값보다 크면 중앙값으로 배정
            for (int i = 0; i < N; i++) {
                totalBudget += cities[i] <= half ? cities[i] : half;
            }

            // 분배할 총 예산이 M보다 크면 상한선을 더 낮춤
            if (totalBudget > M) {
                maxBudget = half - 1;
            }
            // 분배할 총 예산이 M보다 작거나 같으면 상한선을 높혀봄
            else {
                minBudget = half + 1;
                ans = Math.max(ans, half);
            }
        }


        System.out.println(ans);
    }

}
