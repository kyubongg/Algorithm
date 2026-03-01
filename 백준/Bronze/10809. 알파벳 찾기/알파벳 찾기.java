import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 1. 알파벳 개수(26개)만큼 배열 생성 후 -1로 초기화
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        // 2. 단어의 첫 글자부터 탐색
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a'; // 알파벳을 숫자로 변환 (a=0, b=1...)

            // 3. 처음 등장하는 위치만 기록해야 함
            if (alphabet[index] == -1) {
                alphabet[index] = i;
            }
        }

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int val : alphabet) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}