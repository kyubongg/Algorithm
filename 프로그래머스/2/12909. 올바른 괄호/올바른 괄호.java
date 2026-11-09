import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 스택에 ( 이 있을 때 -> (이 오면 넣고 )이 오면 pop
            // 스택이 비어 있는데 )이 오면 false 리턴
            
            
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            }else {
                if (stack.isEmpty()) return false;
                else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            
            
        }
        
        if (!stack.isEmpty()) return false;

        return answer;
    }
}