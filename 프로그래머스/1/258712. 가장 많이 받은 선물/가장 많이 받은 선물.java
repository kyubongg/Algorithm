import java.util.*;
class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int fLen = friends.length;
        int gLen = gifts.length;
        
        // 누가 누구에게 선물을 줬는가?
        Map<String, Integer> giftMap = new HashMap<>();
        for(int i = 0; i < fLen; i++){
            giftMap.put(friends[i], i);
        }
        
        // 한 사람이 몇개의 선물을 주고 몇개의 선물을 받았는가? => 선물지수 계산
        
        int[][] giftArr = new int[fLen][fLen];
        // int[0]: 준 선물 개수, int[1] 받은 선물 개수
        for(int i = 0; i < gifts.length; i++){
            String[] strArr = gifts[i].split(" ");
            
            int from = giftMap.get(strArr[0]);
            int to = giftMap.get(strArr[1]);
            
            giftArr[from][to]++;
        }
        
        // System.out.println(Arrays.deepToString(giftArr));
        // 선물지수 계산
        int[] receiveScores = new int[fLen];
        for(int i = 0; i < fLen; i++){
            int Rsum = 0;           // 받은 선물 개수
            for(int j = 0; j < fLen; j++){
                Rsum += giftArr[j][i];
            }
            
            receiveScores[i] = Rsum;
        }
        
        int[] sendScores = new int[fLen];
        for(int i = 0; i < fLen; i++){
            int Ssum = 0;           // 준 선물 개수
            for(int j = 0; j < fLen; j++){
                Ssum += giftArr[i][j];
            }
            
            sendScores[i] = Ssum;
        }
        
        int[] giftScores = new int[fLen];
        for(int i = 0; i < fLen; i++){
            giftScores[i] = sendScores[i] - receiveScores[i];
        }
        
        // System.out.println(Arrays.toString(giftScores));
        
        int[] ans = new int[fLen];
        boolean[][] visited = new boolean[fLen][fLen];
        // 다음달 받을 선물 계산
        // s: 보낸사람 번호, c: 받은사람 번호
        for(int s = 0; s < fLen; s++){
            for(int r = 0; r < fLen; r++){
                
                if(s == r) continue;
                // System.out.println(s + " " + r);
                // 두 사람이 선물을 주고 받은 기록이 있다면
                // 선물을 더 많이 준 사람이 다음달에 선물을 하나 더 받음
                if(!visited[s][r] && giftArr[s][r] != 0 && giftArr[s][r] != giftArr[r][s]){
                    
                    if(giftArr[s][r] > giftArr[r][s]) ans[s]++;
                    else if(giftArr[s][r] < giftArr[r][s]) ans[r]++;
                    
                    visited[s][r] = true;
                    visited[r][s] = true;
                }
                
                
                // 두 사람이 선물을 주고 받은 기록이 없거나, 둘이 주고 받은 선물의 개수가 같다면
                if(!visited[s][r] && giftArr[r][s] == giftArr[s][r]){

                    
                    // 선물지수로 계산
                    System.out.print("giftCalc");
                    if(giftScores[r] > giftScores[s]) ans[r]++;
                    else if(giftScores[r] < giftScores[s]) ans[s]++;

                    visited[s][r] = true;
                    visited[r][s] = true;
                    
                    
                }
                
//                 System.out.println(Arrays.toString(ans));
                
//                 System.out.println("===============================");
            }
        }
        
        Arrays.sort(ans);
        
        
        return ans[ans.length - 1];
    }
}