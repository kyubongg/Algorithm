import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(line, " ");
        
        System.out.println(st.countTokens());
    }
}