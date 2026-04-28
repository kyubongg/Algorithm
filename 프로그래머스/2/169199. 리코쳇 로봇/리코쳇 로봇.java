import java.util.*;
class Solution {
    
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int solution(String[] board) {
        int answer = 0;
        int startR = 0;
        int startC = 0;
        int endR = 0;
        int endC = 0;
        
        isVisited = new boolean[board.length][board[0].length()];
        map = new char[board.length][board[0].length()];
        for (int i = 0; i < map.length; i++) {
             for (int j = 0; j < map[i].length; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    startR = i;
                    startC = j;
                }
                 
                if (map[i][j] == 'G') {
                    endR = i;
                    endC = j;
                }
            }
        }
        
        answer = bfs(startR, startC, endR, endC);
        
        return answer;
    }
    
    static int bfs(int startR, int startC, int endR, int endC) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startR, startC, 0});
        isVisited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            if (curr[0] == endR && curr[1] == endC) {
                return curr[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = curr[0];
                int nc = curr[1];
                
                
                while (true) {
                    int nextR = nr + drc[i][0];
                    int nextC = nc + drc[i][1];

                    if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length || map[nextR][nextC] == 'D') {
                        break;
                    }
                    nr = nextR;
                    nc = nextC;
                }
                
                if (!isVisited[nr][nc]) {
                    queue.add(new int[] {nr, nc, curr[2] + 1});
                    isVisited[nr][nc] = true;
                }
            } 
        }
        
        return -1;
        
    }
}