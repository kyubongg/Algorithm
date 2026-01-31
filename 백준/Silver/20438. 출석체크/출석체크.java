import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int studentNum = Integer.parseInt(st.nextToken());
        int sleepStudentNum = Integer.parseInt(st.nextToken());
        int codeAcceptStuentNum = Integer.parseInt(st.nextToken());
        int rangeNum = Integer.parseInt(st.nextToken());

        boolean[] isSleeping = new boolean[studentNum + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sleepStudentNum; i++) {
            isSleeping[Integer.parseInt(st.nextToken())] = true;
        }

        boolean[] isAttended = new boolean[studentNum + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < codeAcceptStuentNum; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 코드를 직접 받은 학생이 자고 있으면 아무에게도 전파 못함
            if (isSleeping[num]) continue;

            // 자고 있지 않다면 배수 학생들에게 전파
            // 전파받은 학생이 자고 있다면 출석 처리만 안 됨 (전파는 계속됨)
            for (int tmp = num; tmp <= studentNum + 2; tmp += num) {
                
                if (!isSleeping[tmp]) {
                    isAttended[tmp] = true;
                }
            }
        }

        // 출석하지 못한 학생의 수를 저장
        int[] prefix = new int[studentNum + 3];
        for (int i = 3; i <= studentNum + 2; i++) {
            // 출석 안 했으면 1, 했으면 0을 더함
            int notAttended = isAttended[i] ? 0 : 1;
            prefix[i] = prefix[i - 1] + notAttended;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rangeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());


            sb.append(prefix[right] - prefix[left - 1]).append("\n");
        }
        System.out.print(sb);
    }
}