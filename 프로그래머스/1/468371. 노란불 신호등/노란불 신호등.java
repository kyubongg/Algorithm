import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int limit = 10000000;
        
        // signal의 개수 : 최대 5개
        // 지속 시간 : 최대 18초
        
        
        // 노란불이 1초일 때 : 다음 노란불 == 처음 노란불 + (초록불 + 빨간불) + 1
        // 노란불이 n초일 때 : 다음 노란불 == 처음 노란불 시작 시간 + 지속시간 + (초록불 + 빨간불)
        
        // 4 11 18 25
        // 3 7 11
        
        // 7 : 3 ~ 5, 10 ~ 12
        // 4 11
        
        // 시간 % 전체 순환 시간 == 노란불 시간
        int[] cycleTime = new int[signals.length];
        boolean[][] signalTimes = new boolean[signals.length][21];
        for (int i = 0; i < signals.length; i++) {
            
            int greenTimes = signals[i][0];
            int yellowTimes = signals[i][1];
            int redTimes = signals[i][2];
            
            for (int j = greenTimes + 1; j <= greenTimes + yellowTimes; j++) {
                signalTimes[i][j] = true;     
            }
            
            cycleTime[i] = greenTimes + yellowTimes + redTimes;
        }
        
        int time = 1;
        System.out.println(Arrays.toString(cycleTime));
        while (time <= limit) {
            
            boolean isEquals = true;
            for (int i = 0; i < cycleTime.length; i++) {
                if (signalTimes[i][time % cycleTime[i]] == false) {
                    isEquals = false;
                    break;
                }
            }     
            
            if (isEquals) {
                return time;
            } else {
                time++;
            }
            
        }
        
        
        return -1;
    }
}