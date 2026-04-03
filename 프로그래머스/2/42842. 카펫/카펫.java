import java.util.*;
class Solution {
    static int[] answer;
    public int[] solution(int brown, int yellow) {
        answer = new int[2];
        
        answer = getComb(brown, yellow);

        // yellow의 가로 세로 조합을 다 찾음
        // 해당 조합 가로 * 2 + 세로 * 2 + 4가 brown과 같은지 보면 됨
        
        return answer;
    }
    
    
    static int[] getComb(int brown, int yellow) {
        
        for (int height = 1; height <= (int)Math.sqrt(yellow); height++) {
            if (yellow % height == 0) {
                int width = yellow / height;
                boolean isCarpet = isPossible(brown, width, height);
                if (isCarpet) {
                    return new int[] {width + 2, height + 2};
                }
            }
        }
        
        return null;
    }
    
    static boolean isPossible(int brown, int width, int height) {
        
        return width * 2 + height * 2 + 4 == brown ? true : false;
    }
}