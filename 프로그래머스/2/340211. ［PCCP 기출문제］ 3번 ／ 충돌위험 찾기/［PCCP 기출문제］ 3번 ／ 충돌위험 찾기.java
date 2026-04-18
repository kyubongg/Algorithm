import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        // 각 시간대별(t) 좌표(r, c)에 로봇이 몇 대 있는지 저장
        // 최대 시간은 포인트 간 거리 합이므로 넉넉하게 20000(100포인트 * 100거리) 정도로 잡거나 Map 활용
        Map<Integer, Map<String, Integer>> timeLog = new HashMap<>();
        int maxTime = 0;

        for (int i = 0; i < routes.length; i++) {
            int currentTime = 0;
            
            for (int j = 0; j < routes[i].length - 1; j++) {
                // 포인트 인덱스는 1부터 시작하므로 -1
                int[] start = points[routes[i][j] - 1];
                int[] end = points[routes[i][j+1] - 1];

                int r = start[0];
                int c = start[1];

                // 1. 각 경로의 '시작점' 기록 (제일 처음 로봇이 출발할 때만 기록)
                if (j == 0) {
                    record(timeLog, currentTime, r, c);
                }

                // 2. r 좌표부터 이동
                while (r != end[0]) {
                    r += (r < end[0]) ? 1 : -1;
                    currentTime++;
                    record(timeLog, currentTime, r, c);
                }

                // 3. c 좌표 이동
                while (c != end[1]) {
                    c += (c < end[1]) ? 1 : -1;
                    currentTime++;
                    record(timeLog, currentTime, r, c);
                }
            }
            maxTime = Math.max(maxTime, currentTime);
        }

        // 전체 시간대를 돌며 2대 이상인 경우(충돌) 카운트
        for (int t : timeLog.keySet()) {
            for (int count : timeLog.get(t).values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }

    // 시간대별 좌표에 로봇 수를 기록하는 함수
    private void record(Map<Integer, Map<String, Integer>> timeLog, int t, int r, int c) {
        timeLog.putIfAbsent(t, new HashMap<>());
        String pos = r + "," + c;
        timeLog.get(t).put(pos, timeLog.get(t).getOrDefault(pos, 0) + 1);
    }
}