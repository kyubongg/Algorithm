import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        // 1. 작업 시작 시간을 기준으로 오름차순 정렬
        getPlansOrderByAsc(plans);
        
        // 스택에 넣는 이유는 가장 최근에 멈춘 작업을 우선적으로 처리하기 위해서임
        
        Stack<String[]> delayStack = new Stack<>();
        
        // 2. i, i+1의 시간을 비교
        int answerIdx = 0;
        for (int i = 0; i < plans.length - 1; i++) {
            int diffTime = Integer.parseInt(plans[i+1][1]) - Integer.parseInt(plans[i][1]);
                
            // 2-1. i+1번의 시간 - i번의 시간 >= i번의 작업 시간 -> 작업 완료 가능 -> answer 배열 과제명을 넣음
            if (diffTime >= Integer.parseInt(plans[i][2])) {
                answer[answerIdx++] = plans[i][0];
                diffTime -= Integer.parseInt(plans[i][2]);
                
                while (!delayStack.isEmpty() && diffTime > 0) {
                    String[] plan = delayStack.peek();
                    
                    if (diffTime >= Integer.parseInt(plan[2])) {
                        diffTime -= Integer.parseInt(plan[2]);
                        answer[answerIdx++] = plan[0];
                        delayStack.pop();
                    } else {
                        plan[2] = Integer.toString(Integer.parseInt(plan[2]) - diffTime);
                        diffTime = 0;
                    }
                }
            }
            // 2-2. i+1번의 시간 - i번의 시간 < i번의 작업 시간  -> 작업 완료 불가능 -> 작업 대기 스택에 넣음
            else {
                plans[i][2] = Integer.toString(Integer.parseInt(plans[i][2]) - diffTime);
                delayStack.add(plans[i]);
            }
        }
        
        answer[answerIdx++] = plans[plans.length-1][0];
        
        // 3. 스택에서 하나씩 꺼내서 배열에 과제명을 넣음
        while (!delayStack.isEmpty()) {
            answer[answerIdx++] = delayStack.pop()[0];
        }
        
        
        return answer;
    }
    
    // plans를 넣으면 같은 주소이기 때문에 void로 설정
    static void getPlansOrderByAsc(String[][] plans) {
        
        int orderIdx = 1;   // 1번이 시간이라서 정렬 기준 idx를 설정
        
        for (int i = 0; i < plans.length; i++) {
            String[] timeStr = plans[i][orderIdx].split(":");
            
            plans[i][orderIdx] = Integer.toString(Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]));
        }
        
        Arrays.sort(plans, (a,b) -> Integer.compare(Integer.parseInt(a[orderIdx]), Integer.parseInt(b[orderIdx])));
        
    }
}