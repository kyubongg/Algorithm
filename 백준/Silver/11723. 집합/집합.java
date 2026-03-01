import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            } else if(command.equals("empty")) {
                set.clear();
                continue;
            } else {
                int num = Integer.parseInt(st.nextToken());

                switch(command) {
                    case "add":
                        set.add(num);
                        break;
                    case "remove":
                        set.remove(num);
                        break;
                    case "check":
                        if(set.contains(num)) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "toggle":
                        if(set.contains(num)) set.remove(num);
                        else set.add(num);
                        break;
                }
            }

        }
        System.out.println(sb.toString());

    }
}
