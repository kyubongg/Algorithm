import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }


        int ans = 0;
        for (int i = N-1; i >= 0; i--) {
            if (K <= 0) break;
            ans += K / coins[i];
            K %= coins[i];
        }

        System.out.println(ans);

    }
}
