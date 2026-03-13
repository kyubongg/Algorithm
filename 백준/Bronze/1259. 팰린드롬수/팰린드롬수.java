import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();

            if (input.equals("0")) break;

            boolean flag = true;
            int left = 0;
            int right = input.length()-1;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    flag = false;
                    break;
                }

                left++;
                right--;
            }

            if (flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }

        System.out.println(sb.toString());

    }


}
