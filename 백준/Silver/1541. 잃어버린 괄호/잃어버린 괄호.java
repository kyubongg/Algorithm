import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        String[] minus = str.split("-");


        for (int i = 0; i < minus.length; i++) {

            String[] plus = minus[i].split("[+]");

            int sum = 0;
            for (int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt(plus[j]);
            }
            minus[i] = String.valueOf(sum);
        }

        int ans = Integer.parseInt(minus[0]);
        for (int i = 1; i < minus.length; i++) {
            ans -= Integer.parseInt(minus[i]);
        }

        System.out.println(ans);
    }


}
