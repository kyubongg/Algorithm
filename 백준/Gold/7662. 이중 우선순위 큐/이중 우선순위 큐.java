import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for  (int T = 1; T <= tc; T++) {
            int k = Integer.parseInt(br.readLine());

            // 값 삽입, 최소값 제거, 최대값 제거 연산이 있음
            // 우선순위 큐를 두개 사용한다.

            // 내림차순 우선순위큐, 오름차순 우선순위 큐
            // 값 삽입은 두 큐에 다 넣는걸로 하고,
            // 값 제거
            //  - 최소값 : 오름차순 우선순위큐에서 제거
            //  - 최대값 : 내림차순 우선순위큐에서 제거

            // 두 우선순위 큐가 같은 주소면 되지 않나?
            // 배열을 만들고 그걸 우선순위큐로 바꾸는거임

            TreeMap<Integer,Integer> map = new TreeMap<>();

            StringTokenizer st;
            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    // map이 비어있으면 D 명령 무시
                    if (map.isEmpty()) continue;

                    // 최대값 제거
                    if (num == 1) {
                        int maxKey = map.lastKey();
                        int count = map.get(maxKey);

                        if (count == 1) map.remove(maxKey);
                        else map.put(maxKey, count - 1);
                    }
                    // 최소값 제거
                    else {
                        int minKey = map.firstKey();
                        int count = map.get(minKey);

                        if (count == 1) map.remove(minKey);
                        else map.put(minKey, count - 1);
                    }
                }


            }

            if (map.size() == 0) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
            }
        }

        System.out.println(sb.toString());



    }


}
