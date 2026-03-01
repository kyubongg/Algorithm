import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int[] lens = new int[3];
            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) return;

                lens[i] = num;
            }

            Arrays.sort(lens);

            int a = lens[0];
            int b = lens[1];
            int c = lens[2];

            if (c == Math.sqrt((int) Math.pow(a, 2) + (int) Math.pow(b,2))) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }

    }
}
