import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 나무 자르기
        // 나무가 M 미터 필요함, 톱날이 땅에서부터 H미터 위로 이동, 해당 높이까지의 나무들을 모두 자름

        // 나무의 최대 높이가 10억이기 때문에 나무의 최대 길이 ~ 0까지 반복하면 최대 10억번 반복해야함
        // 이분탐색 알고리즘으로 줄일 예정 -> 시간복잡도 : O(logN) : 최대 30번

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int minH = 0;
        int maxH = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            maxH = Math.max(tree, maxH);
        }

        Arrays.sort(trees);
//        System.out.println(Arrays.toString(trees));
        /**
         * 방법 1
         * - 땅: minH, 최대 나무 길이: maxH
         * - (minH + maxH) / 2로 잘랐을 때 의 값 : treeAmount
         * - treeAmount == M -> return treeAmount
         * - treeAmount < M -> maxH = half로 설정 후 한번 더 자름
         * - treeAmount > M -> 이것보다 더 작은 값이 있는지 찾기 위해서 더 윗부분을 잘라봄 -> minH = half
         */

        int ans = 0;
        int half = (maxH + minH) / 2;
        while (minH <= maxH) {
//            System.out.println(half);
            int idx = N-1;
            long treeAmount = 0;

            // 나무의 길이가 절반 값보다 클때 까지만 나무를 자를 수 있음
            while (idx >= 0 && trees[idx] > half) {
                treeAmount += trees[idx] - half;
                idx--;
            }

            // M과 자른 나무의 수가 크거나 같으면 위에 더 잘라보기
            if (treeAmount >= M) {
//                System.out.println("EQUAL: " + treeAmount);
                minH = half + 1;
                ans = half;

            }
            // 자른 나무의 수 < M -> 나무를 더 잘라보기
            else if (treeAmount < M) {
//                System.out.println("SMALL: " + treeAmount);
                maxH = half - 1;
            }

            half = (maxH + minH) / 2;
        }

        System.out.println(ans);
    }

}
