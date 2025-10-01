import java.util.*;
class Solution {
    static int[] discountPer = {40, 30, 20, 10};
    
    static int[][] gUsers;
    static int[] gEmoticons;
    static int eLen;
    static int[] discountArr;
    static int maxPlus = 0;
    static int maxCost = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        gUsers = users;
        gEmoticons = emoticons;
        eLen = emoticons.length;
        discountArr = new int[eLen];
        
        getComb(0);
        
        return new int[]{maxPlus, maxCost};
    }
    
    static void getComb(int idx){
        if(idx == eLen){
            
            calculate();
            return;
        }
        
        for(int percent : discountPer){
            discountArr[idx] = percent;
            getComb(idx+1);
        }
    }
    
    static void calculate(){
        
        // System.out.println(Arrays.toString(discountArr));
        // 각 이모티콘 할인율에 따른 사용자의 구매 여부 및 금액 구하기
        int[] costs = new int[gUsers.length];
        int sum = 0;
        for(int i = 0; i < eLen; i++){
            int cost = gEmoticons[i] * (100 - discountArr[i]) / 100;
            
            // 해당 유저가 구매할 할인율보다 낮으면 구매 X
            // 해당 유저가 구매할 할인율보다 높거나 같으면 구매 O
            for(int j = 0; j < gUsers.length; j++){
                if(gUsers[j][0] > discountArr[i]) continue;
                else costs[j] += cost;
            }
        }

        
        int plusCnt = 0;    // 이모티콘 플러스 가입자 수
        int cost = 0;       // 이모티콘 판매액
        // 각 이모티콘의 할인율에 따른 사용자의 구매 금액이 이모티콘 플러스 서비스 고려 비용 이상인지 확인
        for(int i = 0; i < costs.length; i++){
            if(costs[i] >= gUsers[i][1]) plusCnt++;
            else cost += costs[i];
        }
        
        // System.out.println(Arrays.toString(costs));
        // System.out.println(plusCnt + " " + cost);
        
        if(plusCnt > maxPlus){
            maxPlus = plusCnt;
            maxCost = cost;
        }else if(plusCnt == maxPlus){
            maxCost = Math.max(maxCost, cost);
        }
        
    }

}