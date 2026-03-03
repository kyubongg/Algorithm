import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++){
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lans[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while (left <= right){
            long mid = (left + right) / 2;

            long count = 0;
            for (int x : lans) {
                count += x / mid;
            }

            if (count >= N) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }


}
