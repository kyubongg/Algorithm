import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 한 줄을 그대로 가져옵니다. (예: "1 2 3 4 5 6 7 8")
        String input = br.readLine();

        // 8개의 숫자가 고정되어 있으므로 문자열 비교가 가장 빠르고 쉽습니다.
        if (input.equals("1 2 3 4 5 6 7 8")) {
            System.out.println("ascending");
        } else if (input.equals("8 7 6 5 4 3 2 1")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}