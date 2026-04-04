class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // 다 비어 있으면 짧은곳부터 배정함
        // 다 차있으면 
        // 현재 각 심사관 마다 남은 시간 + 소요시간 중에 가장 작은 곳으로 감
        
        // 근데 시간이 10억 분 이하고 기다리는 사람이 10억명 이하임
        // 심사관은 10만명이라서 그냥 시간을 카운트하면 시간초과가 남
        
        // 이분탐색을 활용해서
        // time을 정했을 때, 해당 time이 됐을 때 각 심사관이 처리한 사람의 수가 n보다 큰 가장 작은 시간을 구하면 됨
        // time의 최소값 : times 배열 중 가장 작은 값
        // time의 최대값 : ? 10조임 ㄷㄷ
        
        long left = 0;
        long right = 100_000_000_000_00L;
        
        while (left < right) {
            
            long midTime = (left+right) / 2;     // 오버플로우 방지용 중간값 구하기
            
            
            long peoples = getTimes(times, midTime);
            // 심사받은 사람 수가 n보다 작으면 시간을 더 늘려야함 left = mid;
            if (peoples < n) {
                left = midTime+1;
            } 
            // 심사받은 사람 수가 n보다 크면 시간을 줄여서 더 해봄 (최소 시간을 찾아야하기 때문에) right = mid;
            else if (peoples >= n){
                answer = Math.min(answer, midTime);
                right = midTime;
            }
        }
        
        
        return answer;
    }
    
    static long getTimes(int[] times, long time) {
        
        long peoples = 0;
        for (int i = 0; i < times.length; i++) {
            peoples += time / times[i];
        }
        
        return peoples;
    }
}