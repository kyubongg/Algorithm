import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // n은 최대 64까지이므로 long 타입 배열 사용
        long[][] dp = new long[65][10];

        // 초기값 설정: 1자리 수일 때
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP 테이블 채우기 (미리 64까지 계산)
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int T = sc.nextInt(); // 테스트 케이스 개수
        while (T-- > 0) {
            int n = sc.nextInt();
            long sum = 0;
            
            // n자리 수의 모든 경우의 수를 더함
            for (int i = 0; i <= 9; i++) {
                sum += dp[n][i];
            }
            System.out.println(sum);
        }
        
        sc.close();
    }
}