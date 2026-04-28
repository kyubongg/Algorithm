import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int depth = 0;
        
        if (n % w == 0) depth = n / w;
        else depth = n / w + 1;
        
        int[][] boxes = new int[depth][w];
        
        int cnt = 1;
        int targetR = 0, targetC = 0;
        for (int r = 0; r < depth; r++) {
            if (r % 2 == 0){
                for (int c = 0; c < w; c++) {
                    if (cnt == num) {
                        targetR = r;
                        targetC = c;
                    }
                    boxes[r][c] = cnt++;
                    if (cnt > n) break;
                }
            } else {
                for (int c = w-1; c >= 0; c--) {
                    if (cnt == num) {
                        targetR = r;
                        targetC = c;
                    }
                    boxes[r][c] = cnt++;
                    if (cnt > n) break;
                }
            }
            
        }
        
        while (targetR < depth && boxes[targetR][targetC] != 0) {
            answer++;
            targetR++;
            
        }
        // System.out.println(Arrays.deepToString(boxes));
                
        return answer;
    }
}