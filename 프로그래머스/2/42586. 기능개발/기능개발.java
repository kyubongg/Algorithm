import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        /**
         앞 작업이 끝나야 다음 작업을 할 수 있음 -> 큐를 이용
         
         1. 배열을 이용해서 모든 작업에 해당 작업 속도를 더함
         2. 하루치 작업을 더한 작업 배열의 진도가 100보다 크면 큐에서 앞에 있는 작업을 꺼내봄
          2.1. 만약 해당 작업의 작업량이 100이상이면 빼고 큐의 다음 작업도 똑같이 진행
          2.2. 작업량이 100보다 작으면 다시 하루치 작업을 진행
         
        
        */
        
        
        int days = 0;  // 작업 일수
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(i);
        }
        
        while(!q.isEmpty()) {
            
            int today = 0;
            // 작업일수 더하기
            // 작업 진도는 100미만이기 때문에 해당 반복을 시작하기 전에 끝나는건 없음
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            while (!q.isEmpty() && progresses[q.peek()] >= 100) {
                q.poll();
                today++;
            }
            
            if(today > 0) list.add(today);
            
            days++;
        }
            
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}