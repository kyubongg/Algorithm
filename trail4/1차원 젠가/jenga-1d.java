import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        

        StringTokenizer st;

        int diff = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            diff += end-start + 1;
            // 영역내의 블록 제거
            for (int j = start; j <= end; j++) {
                arr[j] = 0;
            }

            int[] tmp = new int[N+1];
            int idx = 1;

            for (int j = 1; j <= N; j++) {
                if (arr[j] != 0) {
                    tmp[idx++] = arr[j];
                }
            }


            arr = tmp;
        }
        
        // 0 ~ N-(뺀 블록 개수 + 1)까지 출력
        System.out.println(N - diff);

        for (int i = 1; i <= N-diff; i++) {
            System.out.println(arr[i]);
        }
    }
}