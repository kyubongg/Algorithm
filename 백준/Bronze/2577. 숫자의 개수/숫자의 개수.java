import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 세 수의 곱 구하기
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int result = A * B * C;
        
        // 2. 0~9까지 개수를 담을 배열 (인덱스 0은 숫자 0의 개수)
        int[] counts = new int[10];

        // 3. 숫자를 문자열로 변환하여 각 자리 확인
        String strResult = String.valueOf(result);
        
        for (int i = 0; i < strResult.length(); i++) {
            // 문자를 숫자로 변환 ('0'을 빼주면 숫자가 됩니다)
            int digit = strResult.charAt(i) - '0';
            counts[digit]++;
        }

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}