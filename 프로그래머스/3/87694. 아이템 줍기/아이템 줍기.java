import java.util.*;
class Solution {
    
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 100_000;
        int N = 102;
        
        // 다각형의 둘레 선 따기
        int[][] map = new int[N][N];
        
        for (int[] rect : rectangle) {
            int y1 = rect[1] * 2;
            int y2 = rect[3] * 2;
            int x1 = rect[0] * 2;
            int x2 = rect[2] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    
                    if (y > y1 && y < y2 && x > x1 && x < x2) {
                        map[y][x] = 2;
                    } else if(map[y][x] != 2) {
                        map[y][x] = 1;
                    }
                    
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        
        int newCY = characterY * 2;
        int nexCX = characterX * 2;
        int newIY = itemY * 2;
        int newIX = itemX * 2;
        
        q.add(new int[] {newCY, nexCX, 0});
        visited[newCY][nexCX] = true;
        
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == newIY && curr[1] == newIX) {
                answer = curr[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + drc[i][0];
                int nc = curr[1] + drc[i][1];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0 || map[nr][nc] == 2) continue;
                
                if (map[nr][nc] == 1) {
                    q.add(new int[] {nr, nc, curr[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        
        
        return answer / 2;
    }
}