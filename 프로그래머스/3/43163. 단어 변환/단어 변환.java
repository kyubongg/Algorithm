import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        if (!wordList.contains(target)) return 0;
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    // 백트래킹
    static void dfs(String now, String target, String[] words, int depth) {
        
        if (now.equals(target)) {
            answer = Math.min(depth, answer);
            return;
        }
        
        if (depth > words.length) return;
        
        // 모든 단어를 검사
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            // now와 words[i]가 한글자 차이면 그걸로 바꿈
            int cnt = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (now.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }
            
            if (cnt == now.length() - 1) {
                visited[i] = true;
                dfs (words[i], target, words, depth+1);
                visited[i] = false;
            }
        } 
    }
}