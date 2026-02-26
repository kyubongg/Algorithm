import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 정답이 될 수 있는 수의 후보는 1 ~ 10,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[N-1];

        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for (int num = min; num <= max; num++) {

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.abs(nums[i] - num);
            }

            if (sum < minDiff) {
                minDiff = sum;
                ans = num;
            }
        }


        System.out.println(ans);
    }
}
