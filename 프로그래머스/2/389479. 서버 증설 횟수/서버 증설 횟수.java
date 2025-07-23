import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        // 조건
        // 서버가 언제 증설되는지, 증설된 서버가 언제 반납되는지를 체크해야됨.
        
        // 1. players 배열 반복문을 돈다.
        // 2. player 수가 m보다 크거나 같으면 증설된 서버의 수와 비교하여 필요한 서버의 개수를 증설해준다.
        //  2.1. player의 수 / m 의 값과 같아질만큼 서버를 늘려줌
        //  2.2. 게임 이용자 수가 m보다 작으면 아무것도 하지않는다.
        
        // 증설 횟수
        int extendCount = 0;
        // 현재 증설된 서버의 수
        int extendServer = 0;
        // 필요한 서버의 수
        int requiredServer = 0;
        
        // 증설된 서버의 수 리스트
        List<Integer> checkServerCount = new ArrayList<>();
        // 서버가 증설된 시간 체크 리스트
        List<Integer> checkExtendTime = new ArrayList<>();
        
        for(int i = 0; i < players.length; i++){
            int playersCount = players[i];
            
            for(int j = 0; j < checkExtendTime.size(); j++){
                checkExtendTime.set(j, checkExtendTime.get(j) + 1);
            }
            
            if(checkExtendTime.size() != 0 && checkExtendTime.get(0) == k){
                extendServer -= checkServerCount.get(0);
                checkServerCount.remove(0);
                checkExtendTime.remove(0);
            }
            
            requiredServer = playersCount / m;
            if(requiredServer > extendServer){
                int newServer = requiredServer - extendServer;
                extendCount += newServer;
                extendServer += newServer;
                
                checkServerCount.add(newServer);
                checkExtendTime.add(0);
            }
            
        }
        
        return extendCount;
    }
}