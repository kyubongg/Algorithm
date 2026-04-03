import java.util.*;

class Solution {

    static Set<Integer> answer;
    static boolean[] visited;
    public int solution(String numbers) {
        answer = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        backTrack("", numbers);
        
        return answer.size();
    }
    
    static void backTrack(String curr, String numbers) {
       
        if (!curr.equals("")) {
            int num = Integer.parseInt(curr);
            
            if (isPrime(num)) {
                answer.add(num);
            }
        }
                
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            backTrack(curr + numbers.charAt(i), numbers);
            visited[i] = false;
        }
        
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}