import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 테스트 케이스 개수 T
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 2. 반복 횟수 R과 문자열 S 분리
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            // 3. 각 문자를 R번 반복
            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                for (int k = 0; k < R; k++) {
                    sb.append(c);
                }
            }
            sb.append("\n"); // 케이스 종료 후 줄바꿈
        }
        
        // 4. 최종 결과 출력
        System.out.print(sb);
    }
}