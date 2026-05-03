import java.util.*;
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        // 직접 회전을 해야함.
        // 회전하면서 회전에 가장 작은 수가 뭔지 알아내야함.
        
        // 시간 복잡도 : 400 * 10000 => 400만
        // 회전할 때 최대 숫자 갯수 : 400개
        // 최대 회전 수 : 10000개
        
        map = new int[rows + 1][columns + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                map[r][c] = (r-1) * columns + c;
            }
        }
        
        answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int top = queries[i][0];
            int left = queries[i][1];
            int bottom = queries[i][2];
            int right = queries[i][3];
            
            answer[i] = rotate(top, left, bottom, right);
        }
        
        return answer;
    }
    
    // 시계방향 회전함수
    static int rotate(int top, int left, int bottom, int right) {
        
        
        
        // 왼쪽 위 좌표의 값을 tmp에 저장
        int tmp = map[top][left];
        int min = tmp;
        
        // 밑에 있는 애들을 위로 끌어 올림
        int topTmp = top;
        while (topTmp < bottom) {
            map[topTmp][left] = map[topTmp + 1][left];
            topTmp++;
            
            min = Math.min(min, map[topTmp][left]);
        }
        
        // 아래쪽 행 회전
        int leftTmp = left;
        while (leftTmp < right) {
            map[bottom][leftTmp] = map[bottom][leftTmp + 1];
            leftTmp++;
            
            min = Math.min(min, map[bottom][leftTmp]);
        }
        
        // 오른쪽 열 회전
        int bottomTmp = bottom;
        while (bottomTmp > top) {
            map[bottomTmp][right] = map[bottomTmp - 1][right];
            bottomTmp--;
            min = Math.min(min, map[bottomTmp][right]);
        }
        
        // 위쪽 행 회전
        int rightTmp = right;
        while (rightTmp > left) {
            map[top][rightTmp] = map[top][rightTmp - 1];
            rightTmp--;
            min = Math.min(min, map[top][rightTmp]);
        }
        
        map[top][left + 1] = tmp;
        
        return min;
    }
}
