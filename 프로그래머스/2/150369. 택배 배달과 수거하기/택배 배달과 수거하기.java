import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        /**
            1. 가장 멀리 배달해야하는 집의 위치를 찾는다.
            2. 해당 집에 배달해야할 상자의 개수를 센다
             2-1. 해당 집에서 배달해야할 상자의 수가 cap보다 작으면
              2-1-1. 그 다음으로 먼 집의 배달 개수를 센다. 만약 남은 배달 상자의 수로 모두 해결할 수 없으면 처음 출발할 때 부터 가장 먼집이 필요로하는 배달개수만큼만 가져간다.
            3. 돌아올 때도 똑같이 한다.
        */
        
        // 배달과 수거를 한번에 처리할 수 있는 인덱스들 구하기
        
        int lastHouse = n-1;
        
        while(lastHouse >= 0) {
            
            while(lastHouse >= 0 && deliveries[lastHouse] == 0 && pickups[lastHouse] == 0) lastHouse--;
            
            if (lastHouse < 0) break;
            answer += (long) ((lastHouse + 1) * 2);
            int d_cap = cap;
            for (int i = lastHouse; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    if (d_cap - deliveries[i] >= 0) {
                        d_cap -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= d_cap;
                        d_cap = 0;
                        break;
                    }
                    
                } 
            }
            
            int p_cap = cap;
            for (int i = lastHouse; i >= 0; i--) {
                if (pickups[i] > 0) {
                    if (p_cap - pickups[i] >= 0) {
                        p_cap -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= p_cap;
                        p_cap = 0;
                        break;
                    }
                    
                } 
            }
            
        }
        
        return answer;
    }
}