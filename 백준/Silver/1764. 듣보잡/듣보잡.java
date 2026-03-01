
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.remove(name)) {
                ans.add(name);
            }
        }

        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for (String name : ans) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
