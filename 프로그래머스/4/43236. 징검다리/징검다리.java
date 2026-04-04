import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        // 이분탐색으로 구하고 최대힙에 넣는다.
        
        // n개의 바위를 제거해야한다.
        // 그럼 바위의 조합을 구해야하나? 50000개를 2개 고르는 경우의 수만 해도 25000 * 49999인데 말이 안된다.
        
        // 출발지 - 바위 - 도착지 거리를 미리 계산한다.
        // 0 2 11 14 17 21 25
      
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;   // 최소값중 최대값일 거라고 예상하는 값
            
            int removeRocks = 0;
            int prevPos = 0;    // 시작점
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prevPos < mid) {
                    removeRocks++;
                } else {
                    prevPos = rocks[i];
                }
            }
            
            if (distance - prevPos < mid) {
                removeRocks++;
            }
            
            // 없앤 돌이 n보다 작거나 같으면 mid값이 더 커져야함
            if (removeRocks <= n) {
                answer = mid;
                left = mid + 1;                
            } else {
                right = mid - 1;
            }            
            
        }
        
        
        return answer;
    }
}