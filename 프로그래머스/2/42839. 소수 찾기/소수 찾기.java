import java.util.*;

class Solution {

    static Set<Integer> answer;
    
    public int solution(String numbers) {
        answer = new HashSet<>();
    
        StringBuilder sb = new StringBuilder();
        getNum(sb, numbers, numbers.length(), -1);
        
        System.out.println(answer);
        
        return answer.size();
    }
    
    static void getNum(StringBuilder sb, String numbers, int len, int prev) {
        if (sb.length() == len) {
           answer.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < len; i++) {
            if(i == prev) continue;
            sb.append(numbers.charAt(i));
            getNum(sb, numbers, len, i);
        }
    }
}