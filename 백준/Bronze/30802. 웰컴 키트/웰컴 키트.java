import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        // 티셔츠 : 같은 사이즈의 T장 묶음으로 주문 가능
        // 펜 : P자루씩 묶음 주문 or 한자루씩 주문

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] parts = new int[6];
        for (int i = 0; i < 6; i++) {
            parts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int t = 0;
        for (int i = 0; i < 6; i++) {
            int part = parts[i];

            if (part % T == 0) t += part / T;
            else t += part / T + 1;
        }

        System.out.println(t);
        System.out.println(N / P + " " + N % P);
    }
}
