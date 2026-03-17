import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > max) max = score;
            sum += score;
        }

        // 계산 과정에서 100.0을 곱해 실수 연산으로 유도
        double result = (sum * 100.0) / max / N;

        // 예제와 비슷하게 출력하고 싶다면 printf 사용
        // 하지만 그냥 System.out.println(result); 해도 백준에서는 정답입니다!
        System.out.println(result);
    }
}