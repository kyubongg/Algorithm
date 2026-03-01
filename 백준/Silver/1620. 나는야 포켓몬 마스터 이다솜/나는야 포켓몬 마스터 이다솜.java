
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

        Map<String, Integer> pMap = new HashMap<>();
        String[] pArr = new String[N+1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pMap.put(name, i);
            pArr[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (Character.isDigit(input.charAt(0))) {
                sb.append(pArr[Integer.parseInt(input)]).append("\n");
            } else {
                sb.append(pMap.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
