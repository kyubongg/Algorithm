import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> comb = new ArrayList<>();
        getComb(comb, 1);

        System.out.println(sb);
    }

    static void getComb(List<Integer> comb, int curr) {

        if (comb.size() == M) {
            for (int i = 0; i < comb.size(); i++) {
                sb.append(comb.get(i));
                if (i != comb.size() - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = curr; i <= N; i++) {

            if (comb.contains(i)) continue;
            comb.add(i);
            getComb(comb, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
