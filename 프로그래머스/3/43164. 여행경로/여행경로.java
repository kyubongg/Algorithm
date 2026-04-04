import java.util.*;
class Solution {
    static boolean finished = false;
    static boolean[] visited;    
    static String[] answer;
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        // 모든 티켓을 다 사용해야함.
        // dfs를 한다.
        // 1. 모든 티켓을 다 사용했을 때
        // 1.1. 가능한 경로가 두개일 때는 알파벳순으로 앞에 있는거 꺼냄
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(tickets, "ICN", 0, list);
        
        return answer;
    }
    
    static void dfs(String[][] tickets, String beforeEnd, int depth, List<String> tmp) {
        if(finished) return;
        
        if (depth == tickets.length) {
            finished = true;
            answer = tmp.toArray(new String[0]);
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) continue;
            
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            
            // 첫 시작일 때 ICN이 아니면 건너뜀
            if (!start.equals(beforeEnd)) continue;
           
            // System.out.println("START : " + start + ", BEFORE : " + beforeEnd + ", END : " + end + ", DEPTH : " + depth);
            
            visited[i] = true;
            tmp.add(end); 
            dfs(tickets, end, depth+1, tmp);
            visited[i] = false;
            tmp.remove(tmp.size()-1);
            
        }
    }
    
}