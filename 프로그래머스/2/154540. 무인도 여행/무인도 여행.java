import java.util.*;
class Solution {
    
    static int rows, cols;
    static char[][] islands;
    static boolean[][] isVisited;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        rows = maps.length;
        cols = maps[0].length();
        
        isVisited = new boolean[rows][cols];
        islands = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            islands[i] = maps[i].toCharArray();
            // System.out.println(Arrays.toString(islands[i]));
        }
        
        
        
        List<Integer> list = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!isVisited[r][c] && islands[r][c] != 'X') {
                    list.add(getDays(r, c));
                }
            }
        }
        
        answer = new int[list.size()];
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
    
    static int getDays(int r, int c){
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        isVisited[r][c] = true;
        
        int days = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            days += islands[curr[0]][curr[1]] - '0';
            
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !isVisited[nr][nc] && islands[nr][nc] != 'X') {
                    isVisited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        
        return days;
    }
}