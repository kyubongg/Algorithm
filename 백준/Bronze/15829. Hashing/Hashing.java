import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int MOD = 1234567891;

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (long)((input.charAt(i) - 'a' + 1) * Math.pow(31, i) % MOD);
        }

        System.out.println(ans);

    }


}
