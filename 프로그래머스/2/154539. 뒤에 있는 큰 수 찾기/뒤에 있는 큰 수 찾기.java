import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        // 스택에는 아직 뒷 큰수를 못 찾은 원소의 인덱스를 넣어요.
        // 새 원소가 들어오면, 스택 맨 위 원소보다 클 동안 계속 꺼내면서 그 인덱스의 answer를 새 원소로 채워요.
        // 그다음 새 원소의 인덱스를 스택에 넣어요.
        // 이렇게 하면 스택 안은 항상 위로 갈수록 작거나 같은 값으로 유지돼요.
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}