class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length; // 직원 수
        
        for (int i = 0; i < n; i++) {
            // 1. 희망 출근 시간을 '분' 단위로 변환 후 10분을 더해 지각 기준선 설정
            int desired = schedules[i];
            int limitMin = (desired / 100) * 60 + (desired % 100) + 10;
            
            boolean isSuccess = true;
            
            for (int j = 0; j < 7; j++) {
                // 2. 현재 날짜의 요일 계산 (1: 월, ... 6: 토, 7: 일)
                int dayOfWeek = (startday - 1 + j) % 7 + 1;
                
                // 3. 주말(토, 일)이면 출근 시간 확인을 건너뜀
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    continue;
                }
                
                // 4. 실제 출근 시간을 '분' 단위로 변환
                int actual = timelogs[i][j];
                int actualMin = (actual / 100) * 60 + (actual % 100);
                
                // 5. 기준선보다 늦게 출근했다면 실패 처리 후 반복 종료
                if (actualMin > limitMin) {
                    isSuccess = false;
                    break;
                }
            }
            
            // 모든 평일을 기준 시간 내에 출근했다면 카운트 증가
            if (isSuccess) {
                answer++;
            }
        }
        
        return answer;
    }
}