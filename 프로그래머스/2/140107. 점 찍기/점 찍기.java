class Solution {
    public long solution(int k, int d) {
        long answer = 0;  // 0포함 점의 개수
        
        // 반지름의 길이가 d인 부채꼴 내의 점들을 찾는 문제
        // y=x 대칭이므로 찾아보는 경우의 수를 1/2로 줄일 수 있음
        // x좌표를 d ~ 0까지 탐색
        //  y좌표를 기준으로 (x,y)의 길이가 d를 넘는지 확인
        //  d를 넘으면 통과, 넘지 않으면 stop => 점의 개수를 셈
        
        
        for (int x = 0; x <= d; x += k) {
            
            // y값이 될 수 있는 후보 => d의 제곱 - x의 제곱보다 작은 y의 제곱 값
            int maxY = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            // System.out.println(maxY);
            answer += maxY / k + 1;
        }
        
        return answer;
    }
    
    static boolean isOverD(int x, int y, int d) {
        return Math.pow(x, 2) + Math.pow(y, 2) > Math.pow(d,2);
    }
}