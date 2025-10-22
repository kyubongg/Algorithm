import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 1. 배달할 상자의 개수(deliverie)와 수거할 상자(pickup)의 개수를 샌다.
        // 2. deliverie와 pickup중 하나가 cap보다 크거나 같아지면
        //    택배 트럭이 배달을 시작함
        
        // 모든 배달업무가 끝날때까지 반복
        int lastHouse = n-1;
        
        while(lastHouse >= 0){
            
            // 가장 끝집 찾기
            while(lastHouse >= 0 && deliveries[lastHouse] == 0 && pickups[lastHouse] == 0){
                lastHouse--;
            }
            
            if(lastHouse < 0) break;
            
            answer += (long)((lastHouse + 1) * 2);
            int d_cap = cap;
            for(int i = lastHouse; i >= 0; i--){
                if(deliveries[i] > 0){
                    if(d_cap > deliveries[i]){
                        d_cap -= deliveries[i];
                        deliveries[i] = 0;
                    }else{
                        deliveries[i] -= d_cap;
                        d_cap = 0;
                        break;
                    }
                }
                
            }
            
            int p_cap = cap;
            for(int i = lastHouse; i >= 0; i--){
                if(pickups[i] > 0){
                    if(p_cap > pickups[i]){
                        p_cap -= pickups[i];
                        pickups[i] = 0;
                    }else{
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