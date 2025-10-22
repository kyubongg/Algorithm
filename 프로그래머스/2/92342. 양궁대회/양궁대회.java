import java.util.*;
class Solution {
    
//     static class RyanScore{
//         int score;
//         int[] 
//     }

    static int MAX_SCORE = 10;
    static int maxDiff = -1;
    static int[] answer = {-1};
    static int[] apeachInfo;
    public int[] solution(int n, int[] info) {
        apeachInfo = info;

        dfs(0, n, 0, 0, new int[MAX_SCORE+1]);
        
        return answer;
    }

    static void dfs(int idx, int n, int ryanScore, int apeachScore, int[] ryanShot){
        // 끝
        if(idx == 11){
            // 화살이 남은 경우
            if(n > 0){
                ryanShot[10] += n;
            }
            
            int diff = ryanScore - apeachScore;
            
            // 라이언이 이기면 최대 점수차와 비교
            if(diff > 0){
                
                if(diff > maxDiff) {
                    maxDiff = diff;
                    answer = Arrays.copyOf(ryanShot, ryanShot.length);
                }
                else if(diff == maxDiff){
                    for(int i = 10; i >= 0; i--){
                        if(ryanShot[i] > answer[i]){
                            answer = Arrays.copyOf(ryanShot, ryanShot.length);
                            break;
                        }else if(ryanShot[i] < answer[i]){
                            break;
                        }
                    }
                }
                
            }
            
            if(n > 0){
                ryanShot[10] -= n;
            }
            return;
        }
        
        
        // 라이언이 이기는 경우
        int needArrow = apeachInfo[idx] + 1;
        if(n >= needArrow){
            ryanShot[idx] = needArrow;
            
            
            dfs(idx+1, n - needArrow, ryanScore + (MAX_SCORE - idx), apeachScore, ryanShot);
            
            ryanShot[idx] = 0;
        }
        
        
        // 어피치가 이기는 경우
        int currentApeach = apeachScore;
        if(apeachInfo[idx] > 0){
            currentApeach += MAX_SCORE - idx;
        }
        
        dfs(idx+1, n, ryanScore, currentApeach, ryanShot);
    }
    
    
    
    
    
}