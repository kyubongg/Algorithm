import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        long[] dp = new long[n]; // 경우의 수를 누적할 dp 배열
        long MOD = 998244353;
        
        // 수열 A 입력 및 dp 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 자기 자신만으로 이루어진 길이가 1인 부분 수열은 무조건 1개 존재
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 이전 원소가 현재 원소보다 작다면 증가하는 부분 수열의 조건을 만족
                if (arr[j] < arr[i]) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dp[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}