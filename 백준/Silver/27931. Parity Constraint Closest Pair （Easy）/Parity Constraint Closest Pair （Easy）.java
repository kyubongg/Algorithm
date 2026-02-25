import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 격자점의 개수가 최대 50만개
        // 50만개 중 2개를 뽑는 조합의 수는 너무 많기 때문에 조합은 아님

        // 짝수 = 홀수 - 홀수 / 짝수 - 짝수
        // 홀수 = 짝수 - 홀수

        // 1. 홀수 짝수 배열을 따로 만들고 저장
        // 2. 짝수의 경우
        // 2.1. 홀수 배열의 최소 거리 뽑기
        // 2.2. 짝수 배열의 최소 거리 뽑기

        // 3. 홀수의 경우
        // 3.1. 짝수, 홀수 배열의 최소 거리 뽑기

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String strNum = st.nextToken();

            if (Integer.parseInt(strNum) % 2 == 0) evens.add(Integer.parseInt(strNum));
            else odds.add(Integer.parseInt(strNum));
        }

        Collections.sort(evens);
        Collections.sort(odds);

        // 짝수 거리 최소값
        int evenMin = Integer.MAX_VALUE;
        for (int i = 0; i < evens.size()-1; i++) {
            evenMin = Math.min(evenMin, Math.abs(evens.get(i) - evens.get(i+1)));
        }

        for (int i = 0; i < odds.size()-1; i++) {
            evenMin = Math.min(evenMin, Math.abs(odds.get(i) - odds.get(i+1)));
        }

        // 홀수 거리 최소 값
        int oddMin = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while(i < evens.size() && j <  odds.size()) {
            oddMin = Math.min(oddMin, Math.abs(evens.get(i) - odds.get(j)));

            if (evens.get(i) < odds.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        evenMin = evenMin == Integer.MAX_VALUE ? -1 : evenMin;
        oddMin = oddMin == Integer.MAX_VALUE ? -1 : oddMin;

        System.out.printf("%d %d", evenMin, oddMin);

    }
}
